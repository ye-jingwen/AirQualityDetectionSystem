package com.example.demo.controller.ucontroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class uDataSystem {
		@RequestMapping(value = "/UserSystem/uDataSystem", method = RequestMethod.GET)
	    public String udatasystem(){
	 
	        return "/US/uDataSystem";
	}
}