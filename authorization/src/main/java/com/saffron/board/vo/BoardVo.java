package com.saffron.board.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {

	private String keyword;
	private int block = 0;
	private int end_page = 0;
	private int next_block = 0;
	private int page = 0;
	private int page_size = 0;
	private int prev_block = 0;
	private int start_index = 0;
	private int start_page = 0;
	private int total_block_cnt = 0;
	private int total_list_cnt = 0;
	private int total_page_cnt = 0;	
	
	private int brdIdx;
	private String userId;
	private String userName;
	private String userEmail;
	private String subject;
	private String content;
	private String delYn;
	private String createDt;
	private String createUser;
	private String modifyDt;
	private String modifyuser;
}
