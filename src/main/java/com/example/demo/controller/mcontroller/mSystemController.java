package com.example.demo.controller.mcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class mSystemController {

	@RequestMapping(value = "/ManagerSystem", method = RequestMethod.GET)
    public String msystemcontroller(){
 
        return "/MS/managersystem";
}
}
