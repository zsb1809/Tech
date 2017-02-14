package com.zhihua.tt.entity;


/*
 * 实体基类
 * 定义了主键ID和自增
 * zhaoshuibo
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8206726473848289117L;

	
	
	/*
	 * 主键唯一+自增
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id ;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	
	
	
	
}
