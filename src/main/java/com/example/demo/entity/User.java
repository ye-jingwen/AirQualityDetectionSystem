package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_test")
public class User implements Serializable{
	private static final long serialVersionUID = 4054155860118698875L;	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;		
	
	//@Column(name="user_name")	
	@Column(columnDefinition="varchar(50) comment '用户名'" )	
	private String userName;	
	
	//@Column(name="pass_word")
	@Column(columnDefinition="varchar(50) comment '密码'")	
	private String passWord;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
