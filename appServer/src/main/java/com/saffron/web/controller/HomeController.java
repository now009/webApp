package com.saffron.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  
	@RequestMapping("/")
	public String index() {
		//http://localhost:8080/
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		//http://localhost:8080/
		return "hello";
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
