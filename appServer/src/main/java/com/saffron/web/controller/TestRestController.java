package com.saffron.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saffron.web.model.Project;
import com.saffron.web.service.HomeService;

//@Slf4j
@RestController
public class TestRestController {
	
	private static Logger log = LoggerFactory.getLogger(TestRestController.class);
	
	//@Autowired
	private HomeService homeService;
	
	@Autowired
	public TestRestController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@RequestMapping(value="/testRestValue", method = RequestMethod.GET)
    public String getTestValue(){
        String TestValue = "레스트컨트롤러 테스트";
        return TestValue;
    }
	
	@GetMapping("/info")
	public Object projectInfo() {
		Project project = homeService.getProjectInfo();
		return project;
	}
	
	@GetMapping("/info2")
	public String customJson() {
		log.debug("===TestRestController#customJson -> /info2" );
		JsonObject jo = new JsonObject();
		
		jo.addProperty("projectName","PreWorld");
		jo.addProperty("autho","TestRest User");
		jo.addProperty("createDate",new Date().toString());
		
		JsonArray ja = new JsonArray();
		for(int i=0;i<5;i++) {
			JsonObject jObj = new JsonObject();
			jObj.addProperty("prop" + i , i);
			ja.add(jObj);
		}
	
		jo.add("follower", ja);
		
		return jo.toString();
	}
	
}
