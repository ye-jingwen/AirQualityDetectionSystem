package com.example.demo.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Shebei;


public interface IShebeiJpaRepository extends CrudRepository<Shebei, Long>{
	public List<Shebei> findByUserName(String userName);	
	public List<Shebei> findAll();
	public Optional<Shebei> getShebeiById(Long id);	
}
