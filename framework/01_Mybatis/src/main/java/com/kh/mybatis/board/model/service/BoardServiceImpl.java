package com.kh.mybatis.board.model.service;

import static com.kh.mybatis.common.template.SqlSessionTemplate.getSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardServiceImpl implements BoardService {

	@Override
	public int getBoardCount() {
		int count = 0;
		SqlSession session = getSession();
		
		count = new BoardDao().getBoardCount(session);
		
		log.debug("전체 게시글 수 : {}", count);
		
		session.close();
		
		return count;
	}

	@Override
	public List<Board> getBoardList(PageInfo pageInfo) {
		List<Board> list = null;
		SqlSession session = getSession();
		
		list = new BoardDao().findAll(session, pageInfo);
		
		session.close();
		
		return list;
	}

	@Override
	public int getBoardCount(String type, String keyword) {
		int count = 0;
		SqlSession session = getSession();
		
		count = new BoardDao().getBoardCount(session, type, keyword);
		
		session.close();
		
		return count;
	}
	
	@Override
	public List<Board> getBoardList(PageInfo pageInfo, String type, String keyword) {
		List<Board> list = null;
		SqlSession session = getSession();
		
		list = new BoardDao().findAll(session, pageInfo, type, keyword);
		
		session.close();
		
		return list;
	}

	@Override
	public int getBoardCount(String[] filters) {
		int count = 0;
		SqlSession session = getSession();
		
		count = new BoardDao().getBoardCount(session, filters);
		
		session.close();
		
		return count;
	}
	
	@Override
	public List<Board> getBoardList(PageInfo pageInfo, String[] filters) {
		List<Board> list = null;
		SqlSession session = getSession();
		
		list = new BoardDao().findAll(session, pageInfo, filters);
		
		session.close();
		
		return list;
	}

	@Override
	public Board getBoardByNo(int no) {
		Board board = null;
		SqlSession session = getSession();
		
		board = new BoardDao().findBoardByNo(session, no);
		
		session.close();
		
		return board;
	}

	@Override
	public int save(Board board) {
		int result = 0;
		SqlSession session = getSession();
		
		if (board.getNo() > 0) {
			// update
			result = new BoardDao().updateBoard(session, board);
		} else {
			// insert
			result = new BoardDao().insertBoard(session, board);
		}
		
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();		
		
		return result;
	}

	@Override
	public int delete(int no) {
		int result = 0;
		SqlSession session = getSession();
		
		result = new BoardDao().updateStatus(session, no, "N");
		
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
}