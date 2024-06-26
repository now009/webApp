package com.saffron.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.saffron.board.repository.BoardMapper;
import com.saffron.board.vo.BoardVo;
import com.saffron.common.UserResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	public List<BoardVo> selectBoardList() {
       return boardMapper.selectBoardList();	
	}
	
    public BoardVo selectBoardView(int brdIdx) {
        return boardMapper.selectBoardView(brdIdx);
    }

    public int insertBoard(BoardVo boardVo) {
    	return boardMapper.insertBoard(boardVo);
    }

    public int updateBoard(BoardVo boardVo) {
    	return boardMapper.updateBoard(boardVo);
    }

    public int deleteBoard(int brdIdx) {
    	return boardMapper.deleteBoard(brdIdx);
    } 	
} 
