package com.zhihua.tt.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zhihua.tt.entity.BaseEntity;

//”√ªß±Ì
@Entity
@Table(name="user")
public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853667781756771458L;
	
	
	
	@Column(name="username",nullable=false,length=30)
	private String username ;
	
	@Column(name="password",nullable=false,length=30)
	private String password ;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
