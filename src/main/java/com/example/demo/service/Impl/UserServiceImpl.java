package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.respository.IUserJpaRepository;
import com.example.demo.service.IUserService;



@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private IUserJpaRepository usr;
	
	@Override	
	public List<User> findAll() {				
		return usr.findAll();	
	} 	
	
	@Transactional	
	@Override	
	public void delete(Long id) {         
		usr.deleteById(id);	
	} 	
	@Override	
	public List<User> findByName(String userName) {		
		//List<User> list1=usr.findByUserName1(userName);		
		//List<User> list2=usr.findByUserName2(userName);		
		//List<User> list3=usr.findByUserNameAndPassWord(userName, "123");		
		//System.out.println("list1:"+list1);		
		//System.out.println("list2:"+list2);		
		//System.out.println("list3:"+list3);					
		return usr.findByUserName(userName);	
	} 	
	@Transactional	
	@Override	
	public void saveUser(User user) {		
		usr.save(user);			
	} 	
	@Transactional	
	@Override	
	public void saveUserList(List<User> list) {		
		usr.saveAll(list);			
	} 	
	
	@Override	
	public Optional<User> getUserById(Long id) {				
		return usr.findById(id);	
	}
	
}
