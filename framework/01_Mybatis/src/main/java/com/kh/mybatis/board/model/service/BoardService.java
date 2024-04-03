package com.kh.mybatis.board.model.service;

import java.util.List;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

public interface BoardService {

	int getBoardCount();

	int getBoardCount(String type, String keyword);
	
	int getBoardCount(String[] filters);
	
	List<Board> getBoardList(PageInfo pageInfo);

	List<Board> getBoardList(PageInfo pageInfo, String type, String keyword);

	List<Board> getBoardList(PageInfo pageInfo, String[] filters);

	Board getBoardByNo(int no);

	int save(Board board);

	int delete(int no);
}
