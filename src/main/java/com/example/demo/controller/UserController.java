package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping(value="/users")
public class UserController {
	@Resource
	private IUserService userService;
	

//    @RequestMapping("/a")
//    public String  hello(String username)
//    {
//        if(username.equals("ljl"))
//        {
//            return "success";   //如果ajax请求过来的参数满足判断条件返回success
//        }
// 
//        return "failure";    //如果ajax请求过来的参数不满足判断条件就failure
//    }
    @RequestMapping("/a")
    public String  hello(String username)
    {
        if(username.equals("ljl"))
        {
            return "success";   //如果ajax请求过来的参数满足判断条件返回success
        }
 
        return "failure";    //如果ajax请求过来的参数不满足判断条件就failure
    }
	
	@RequestMapping(value="/add/{id}/{userName}/{passWord}")
	public User addUser(@PathVariable Long id, @PathVariable String userName,@PathVariable String passWord) {	
		User user=new User();		
		user.setId(id);		
		user.setUserName(userName);		
		user.setPassWord(passWord);		
		userService.saveUser(user);		
		return user;	
	}
	
	@RequestMapping(value="/adduser")
	public User addUser1(@RequestParam(value="userName")String username,@RequestParam(value="password")String password) {	
		User user=new User();		
		
		user.setUserName(username);		
		user.setPassWord(password);		
		userService.saveUser(user);		
		return user;	
	}
	
	@RequestMapping(value="/")	
	public List<User> getUsers(){		
		return userService.findAll();	
	}		
	
	@RequestMapping(value="/{id}")	
	public User getUser(@PathVariable Long id) {		
		Optional<User> usr = userService.getUserById(id) ;
		if(!usr.isEmpty())
		return usr.get();
		else {
			return new User();
		}
	}	
	@RequestMapping(value="delete/{id}")	
	public void deleteUser(@PathVariable Long id) {		
		  userService.delete(id) ;			
	}	
	@RequestMapping(value="/search/userName/{userName}")	
	public List<User> getUserByUserName(@PathVariable String userName){		
		List<User> list=userService.findByName(userName);		
	    return list;		
	}
	
}
