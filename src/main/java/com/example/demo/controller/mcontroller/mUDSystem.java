package com.example.demo.controller.mcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class mUDSystem {
	@RequestMapping(value = "/ManagerSystem/mUDSystem", method = RequestMethod.GET)
    public String mudsystem(){
 
        return "/MS/mUDSystem";
}
}
