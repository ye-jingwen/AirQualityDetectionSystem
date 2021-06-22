package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

public interface IUserService {
	//获取所有
	public List<User> findAll();		
	//根据id获取用户	
	public Optional<User> getUserById(Long id);		
	//根据id删除	
	public void delete(Long id);		
	//根据用户名查询	
	public List<User> findByName(String userName);		
	//保存	
	public void saveUser(User user);		
	//批量保存	
	public void saveUserList(List<User> list);
	
}
