package com.example.demo.controller;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Shebei;
import com.example.demo.service.IShebeiService;

@RestController
@CrossOrigin
@RequestMapping(value="/shebeis")
public class ShebeiController {
	@Resource
	private IShebeiService shebeiService;
	
	
	@RequestMapping(value="/addshebei")
	public void addShebei(@RequestParam(value="userName")String userName,@RequestParam(value="shebeiname")String shebeiname,@RequestParam(value="shebeiID")String shebeiID) 
	{	
		Shebei shebei=new Shebei();			
		shebei.setUserName(userName);		
		shebei.setShebeiname(shebeiname);	
		shebei.setShebeiID(shebeiID);
		shebeiService.saveShebei(shebei);				
	}
	
	@RequestMapping(value="/getallshebei")	
	public List<Shebei> getShebeis(){		
		return shebeiService.findAll();	
	}		
	
	
	@RequestMapping(value="delete/{id}")	
	public void deleteShebei(@PathVariable Long id) {		
		 shebeiService.delete(id) ;			
	}	
	@RequestMapping(value="/search/userName/{userName}")	
	public List<Shebei> getShebeiByUserName(@PathVariable String userName){		
		List<Shebei> list=shebeiService.findByName(userName);		
	    return list;		
	}
}
