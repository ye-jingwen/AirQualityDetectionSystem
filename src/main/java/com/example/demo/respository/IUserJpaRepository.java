package com.example.demo.respository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface IUserJpaRepository extends CrudRepository<User, Long>{
	public List<User> findByUserNameAndPassWord(String userName,String passWord);		
	public List<User> findByUserName(String userName);	
	public List<User> findAll();
	@Query("from User where userName=:userName")	
	public List<User> findByUserName1(@Param("userName") String userName);	
	
	//nativeQuery配置查询的方式是否是本地查询，默认是false	
	//所谓本地查询，就是使用原生的sql语句（根据数据库的不同，在sql的语法或结构方面可能有所区别）进行查询数据库的操作	
	//entityName对应的实体的名字	
	//@Query(value="select * from #{#entityName} where userName=?1",nativeQuery=true)	
	@Query(value="select * from user_test where user_name=?1",nativeQuery=true)	
	public List<User> findByUserName2(String userName);		
	
	//public Optional<User> findById(Long id);
	
}
