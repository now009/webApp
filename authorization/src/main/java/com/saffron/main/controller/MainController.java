package com.saffron.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping(value = "/mainView")
    public String mainView(@RequestParam String code) {
		String value = "테스트  String";
		return "main";
    }
    
	@RequestMapping("/")
	public String index() {
		//http://localhost:8080/
		return "index";
	}
	
	//@RequestMapping("/home")
	//public String home() {
	//	return "home.html";
	//}
	
	@ResponseBody
	@RequestMapping("/valueTest")
	public String valueTest() {
		String value = "테스트  String";
		return value;
	}    
}


