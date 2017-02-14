package com.zhihua.tt.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.zhihua.tt.entity.BaseEntity;

public interface BaseDao<T extends BaseEntity> {
	

	public Serializable save(T entity);
	public void saveOrUpdate(T entity);
	public void remove(long id);
	public void remove(T entity);
	public void update(T entity);
	public T get(Map<String,Object> map);
	
	public T get(long id);
	
	
	public List<T> list(DetachedCriteria  criteria);
	
	public List<T> list(String hql  , Object... args);
	
	public void batchSaveOrUpdate(List<T> list);
	public void batchRemove(List<T> list);
	
	
	public List<Map<String,Object>> sqlQuery(String sql,Object...args);
	public int sqlUpdate(String sql,Object...args);
	

	
}
