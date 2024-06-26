package com.saffron.board.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.saffron.board.service.BoardService;
import com.saffron.board.vo.BoardVo;
import com.saffron.common.UserResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {

	private static Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
    @GetMapping(value = "/list") 
    public List<BoardVo> getBoardList(@RequestParam Map<String,String> req) {
    	List<BoardVo> list = boardService.selectBoardList();
		return list;
    }
    
    @GetMapping("/view/{brdIdx}")
    public UserResponse selectBoardView(@PathVariable int brdIdx) {
        return new UserResponse(boardService.selectBoardView(brdIdx));
    }

    @PostMapping("/create")
    public UserResponse insertBoard(@RequestBody BoardVo boardVo) {
    	int result = boardService.insertBoard(boardVo);
    	UserResponse response = new UserResponse();
    	response.setSuccess(true);
    	return response;
    }

    @PatchMapping("/update")
    public UserResponse updateBoard(@RequestBody BoardVo boardVo) {
    	int result = boardService.updateBoard(boardVo);
    	UserResponse response = new UserResponse();
    	response.setSuccess(true);
    	return response;    	
    }

    @DeleteMapping("/delete/{brdIdx}")
    public UserResponse deleteBoard(@PathVariable int brdIdx) {
    	int result = boardService.deleteBoard(brdIdx);
    	UserResponse response = new UserResponse();
    	response.setSuccess(true);
    	return response;  
    }    
}
