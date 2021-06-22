package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shebei_test")
public class Shebei implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	//@Column(name="user_name")	
	@Column(columnDefinition="varchar(50) comment '用户名'" )	
	private String userName;	
	
	//@Column(name="pass_word")
	@Column(columnDefinition="varchar(50) comment '设备名称'")	
	private String shebeiname;
	
	@Column(columnDefinition="varchar(50) comment '设备标识id'")	
	private String shebeiID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShebeiname() {
		return shebeiname;
	}

	public void setShebeiname(String shebeiname) {
		this.shebeiname = shebeiname;
	}

	public String getShebeiID() {
		return shebeiID;
	}

	public void setShebeiID(String shebeiID) {
		this.shebeiID = shebeiID;
	}
	
}
