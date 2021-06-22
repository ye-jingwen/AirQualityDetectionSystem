package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Shebei;

public interface IShebeiService {
	//获取所有
		public List<Shebei> findAll();		
		//根据id获取用户	
		public Optional<Shebei> getShebeiById(Long id);		
		//根据id删除	
		public void delete(Long id);		
		//根据用户名查询	
		public List<Shebei> findByName(String userName);		
		//保存	
		public void saveShebei(Shebei shebei);		
		//批量保存	
		public void saveShebeiList(List<Shebei> list);
}
