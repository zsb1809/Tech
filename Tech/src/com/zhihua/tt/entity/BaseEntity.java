package com.zhihua.tt.entity;


/*
 * ʵ�����
 * ����������ID������
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
	 * ����Ψһ+����
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
