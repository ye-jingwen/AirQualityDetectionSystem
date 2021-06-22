package com.example.demo.controller.ucontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class uDeviceSystem {
		@RequestMapping(value = "/UserSystem/uDeviceSystem", method = RequestMethod.GET)
	    public String udevicesystem(){
	 
	        return "/US/uDeviceSystem";
	}
}
