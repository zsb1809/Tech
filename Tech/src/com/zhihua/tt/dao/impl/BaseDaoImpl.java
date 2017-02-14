package com.zhihua.tt.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.zhihua.tt.dao.BaseDao;
import com.zhihua.tt.entity.BaseEntity;
import com.zhihua.tt.exception.DataNotExistException;
import com.zhihua.tt.exception.ParameterCanNotBeNullException;
import com.zhihua.tt.util.ReflectionUtils;

@Transactional
public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final ThreadLocal<Session> context = new ThreadLocal<Session>();
	
	@Autowired
	private HibernateTemplate hibernateTemplate ;
	
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<T> entityClass;
	
	
	public BaseDaoImpl() {
		
		entityClass = ReflectionUtils.getSuperClassGenricType(getClass());			
		
	}

	@Override
	public Serializable save(T t) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().save(t); 
		//return hibernateTemplate.save(t);
	}

	@Override
	public void remove(long id) {
		//T t = hibernateTemplate.get(entityClass, id);
		Session session = sessionFactory.getCurrentSession();
		T t = session.load(entityClass, id);
		if(null==t){
			throw new DataNotExistException("id为"+id+"的对象不存在!");
		}
		session.delete(t);

	}
	
	@Override
	public void remove(T entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(entity);
	}
	

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
		
		T t = hibernateTemplate.get(entityClass, entity.getId());
		if(null==t){
			throw new DataNotExistException("id为"+entity.getId()+"的对象不存在!");
		}
		
		hibernateTemplate.saveOrUpdate(entity);
	}

	
	@Override
	public T get(Map<String,Object> map) {
		
		if(map.isEmpty()){
			throw new ParameterCanNotBeNullException("参数不能为空！");
		}
		
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		
		for(String key:map.keySet()){
			criteria.add(Restrictions.eq(key, map.get(key)));
		}
		
		List<T> list =  (List<T>) hibernateTemplate.findByCriteria(criteria);
		
		if(list.size()>0){
			return list.get(0);
		}
		return null ;
	}

	@Override
	public List<T> list(DetachedCriteria criteria) {
		// TODO Auto-generated method stub

		List<T> list =  (List<T>) hibernateTemplate.findByCriteria(criteria);
		return list;
	
	}
	
	
	@Override
	public List<T> list(String hql, Object...values) {
		// TODO Auto-generated method stub
		
		Assert.hasText(hql, "hql不能为空");
		
		List<T> list =  (List<T>) hibernateTemplate.find(hql, values);
		return list ;
	}
	
	
	

	@Override
	public void batchSaveOrUpdate(List<T> list) {
		// TODO Auto-generated method stub
		for(T t:list){
			hibernateTemplate.saveOrUpdate(t);
		}
	}

	

	@Override
	public void batchRemove(List<T> list) {
		// TODO Auto-generated method stub
		for(T t : list){
			hibernateTemplate.delete(t);
		}
	}

	@Override
	public List<Map<String,Object>> sqlQuery(String sql,Object...args) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList(sql, args);
	}

	@Override
	public int sqlUpdate(String sql,Object...args) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(sql, args);
	}
	
	
	/**
	 * 取得当前Session，如果未找到，则检索并返回当前线程创建的Session，如当前线程未创建Session，则创建之
	 */
	public Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			if(logger.isDebugEnabled())
				logger.debug("call getCurrentSession function failure, from thread to get Session!");
			
			Session session = context.get();
			if (session == null) {
				if(logger.isDebugEnabled())
					logger.debug("...call SessionFactoryUtils.getSession(sessionFactory, true) function to get Session!");
				
				//session = SessionFactoryUtils.getSession(sessionFactory, true);
				session = sessionFactory.openSession();
				
				context.set(session);
			}
			
			return session;
		}
	}

	@Override
	public T get(long id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(entityClass, id);

	}

	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(entity);
	}

}
