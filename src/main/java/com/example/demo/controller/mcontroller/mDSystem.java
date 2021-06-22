package com.example.demo.controller.mcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class mDSystem {
	@RequestMapping(value = "/ManagerSystem/mDeviceSystem", method = RequestMethod.GET)
    public String mdsystem(){
 
        return "/MS/mDeviceSystem";
}
}