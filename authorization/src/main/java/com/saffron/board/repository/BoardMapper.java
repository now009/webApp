package com.saffron.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.saffron.board.vo.BoardVo;
import com.saffron.common.UserResponse;

@Mapper
public interface BoardMapper {

	List<BoardVo> selectBoardList();
	BoardVo selectBoardView(int brdIdx);
	int insertBoard(BoardVo boardVo);
	int updateBoard(BoardVo boardVo);
	int deleteBoard(int brdIdx);
	
}
