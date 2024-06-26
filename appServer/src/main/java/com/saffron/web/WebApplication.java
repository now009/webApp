package com.saffron.web;

import java.sql.Connection;

import javax.sql.DataSource;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.filter.reactive.HiddenHttpMethodFilter;

//@MapperScan("com.saffron.mybatis")
@SpringBootApplication
public class WebApplication {

	//@Autowired
	//static DataSource dataSource;
	
	public static void main(String[] args) {
		System.out.println("==================== WebApplication Start ======================");	
		/*
		try {
			Connection connection = dataSource.getConnection();
	        System.out.println("Url: " + connection.getMetaData().getURL());
	        System.out.println("UserName: " + connection.getMetaData().getUserName());
		}catch(Exception e) {
			e.printStackTrace();
		}
        */
		
		SpringApplication.run(WebApplication.class, args);
		
	}

}
