package com.example.demo.controller.mcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class mUSystem {
	@RequestMapping(value = "/ManagerSystem/mUserSystem", method = RequestMethod.GET)
    public String musystem(){
 
        return "/MS/mUserSystem";
}
}
