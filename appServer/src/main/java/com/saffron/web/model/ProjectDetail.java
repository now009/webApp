package com.saffron.web.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//JsonInclude(JsonInclude.Include.NON NULL  -> null 이 아닌것만 return 에 포함. 
public class ProjectDetail {
	public String projectName;
	
	//class의 property name 그대로 보여주지 않고 변경해서 보여줄때.
	//@JsonProperty(value="project master"
	public String author;
	
	//@JsonIgnore -> json생성시 제외
	//JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-mm-dd")
	public Date createdDate;
	
	
}
