package com.saffron.web.service;

import org.springframework.stereotype.Service;

import com.saffron.web.model.Project;

@Service
public class HomeService {

	public Project getProjectInfo() {
		Project project = new Project();
		
		project.setProjectName("PreWord");
		project.setAuthor("Hello-HomeService");
		project.setCreateDate("20230101");
		
		return project;
	}
	
}
