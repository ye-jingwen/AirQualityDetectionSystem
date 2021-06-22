package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Shebei;
import com.example.demo.respository.IShebeiJpaRepository;

import com.example.demo.service.IShebeiService;
@Service
public class ShebeiServiceImpl implements IShebeiService{
	@Resource
	private IShebeiJpaRepository sheb;
	@Override
	public List<Shebei> findAll() {
		// TODO Auto-generated method stub
		return sheb.findAll();
	}

	@Override
	public Optional<Shebei> getShebeiById(Long id) {
		// TODO Auto-generated method stub
		return  sheb.getShebeiById(id);
	}
	@Transactional
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		sheb.deleteById(id);
		
	}

	@Override
	public List<Shebei> findByName(String userName) {
		// TODO Auto-generated method stub
		return sheb.findByUserName(userName);
	}
	@Transactional	
	@Override
	public void saveShebei(Shebei shebei) {
		// TODO Auto-generated method stub
		sheb.save(shebei);
	}
	@Transactional
	@Override
	public void saveShebeiList(List<Shebei> list) {
		// TODO Auto-generated method stub
		sheb.saveAll(list);
	}

}
