package com.saffron.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
//import com.saffron.mybatis.entity.ContinentCodeEntity;
//import com.saffron.mybatis.inf.MyBatisSampleInf;
import com.saffron.web.service.HomeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RestController
public class MyBatisSampleController {

	private static Logger log = LoggerFactory.getLogger(MyBatisSampleController.class);
//	
//	private MyBatisSampleInf myBatisSampleInf;
//	
//	@Autowired
//	public MyBatisSampleController(MyBatisSampleInf myBatisSampleInf) {
//		log.debug("===MyBatisSampleController : MyBatisSampleInf  @Autowired" );
//		this.myBatisSampleInf = myBatisSampleInf;
//	}
//	
//	@GetMapping("/mybatisSample")
//	public Map<String,Object> mybatisSample() {
//		log.debug("===ContinentCodeInf#mybatisSample -> /mybatisSample" );
//		
//		Map<String,Object> rtnObj = new HashMap<String,Object>();
//		List<ContinentCodeEntity> continentCodeList = myBatisSampleInf.selectAllContinentCode();
//		rtnObj.put("continentCodeList", continentCodeList);
//		
//		return rtnObj;
//	}
}
