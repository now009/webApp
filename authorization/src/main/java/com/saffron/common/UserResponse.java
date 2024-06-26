package com.saffron.common;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

	public UserResponse(){};
	public UserResponse(Object object) {
		setResult(object);
	}
	
	private Paging paging;
	private boolean isSuccess;
	private int code;
	
	//Result Data
	private Object data;
		
	private int totalCount = 0;
	
	public void setResult(Object obj) {
		this.data = obj;
		
        if(obj instanceof List ) {
		  if(obj != null) {
			this.totalCount = ((List)obj).size();  
		  }
		}
	}	
	
	public void setSuccess(boolean result) {
		this.isSuccess = result;
	}
	
	class Paging {
        int block = 0;
        int end_page = 0;
        int next_block = 0;
        int page = 0;
        int page_size = 0;
        int prev_block = 0;
        int start_index = 0;
        int start_page = 0;
        int total_block_cnt = 0;
        int total_list_cnt = 0;
        int total_page_cnt = 0;	
	}
}
