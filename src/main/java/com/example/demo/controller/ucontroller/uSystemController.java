package com.example.demo.controller.ucontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class uSystemController {

	@RequestMapping(value = "/UserSystem", method = RequestMethod.GET)
    public String usystemcontroller(){
 
        return "/US/usersystem";
    }
}