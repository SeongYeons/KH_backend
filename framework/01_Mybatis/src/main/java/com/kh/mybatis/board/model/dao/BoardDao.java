package com.kh.mybatis.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

public class BoardDao {

	public int getBoardCount(SqlSession session) {
		
		return session.selectOne("boardMapper.selectBoardCount");
	}

	public List<Board> findAll(SqlSession session, PageInfo pageInfo) {
		/*
		 * Mybatis에서 페이징 처리
		 * 
		 * Mybatis에서는 페이징 처리를 위해서 RowBounds라는 클래스를 제공한다.
		 * RowBounds 객체를 생성할 때 offset과 limit 값을 전달해서 페이징 처리를 한다.
		 * (offset 만큼 건너뛰고 limit 만큼 가져온다.)
		 * 
		 *  offset = 0, limit = 10
		 *    - 0개를 건너뛰고 10개를 가져온다. (1 ~ 10)
		 *  
		 *  offset = 10, limit = 10
		 *    - 10개를 건너뛰고 10개를 가져온다. (11 ~ 20)
		 */
		
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return session.selectList("boardMapper.selectAll", null, rowBounds);
	}

	public int getBoardCount(SqlSession session, String type, String keyword) {
		Map<String, String> map = new HashMap<>();
		
		map.put("type", type);
		map.put("keyword", keyword);

		return session.selectOne("boardMapper.selectBoardCountByKeyword", map);
	}

	public List<Board> findAll(SqlSession session, PageInfo pageInfo, String type, String keyword) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<>();
		
		map.put("type", type);
		map.put("keyword", keyword);
		
		return session.selectList("boardMapper.selectBoardListByKeyword", map, rowBounds);
	}

	public int getBoardCount(SqlSession session, String[] filters) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("filters", filters);
		
		return session.selectOne("boardMapper.selectBoardCountByFilters", map);
	}
	
	public List<Board> findAll(SqlSession session, PageInfo pageInfo, String[] filters) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		/*
		 * List, Array 타입의 데이터를 파라미터로 전달하면 
		 * mapper.xml에서는 list, array라는 이름으로 파라미터에 접근해야 한다.
		 * 
		 * 만약에 mapper.xml에서 filters라는 이름으로 사용하고 싶으면
		 * Map 객체에 담아서 파라미터로 전달한다.
		 */
		Map<String, Object> map = new HashMap<>();
		
		map.put("filters", filters);
		
//		return session.selectList("boardMapper.selectBoardListByFilters", filters);
		return session.selectList("boardMapper.selectBoardListByFilters", map, rowBounds);
	}

	public Board findBoardByNo(SqlSession session, int no) {
		
		return session.selectOne("boardMapper.selectBoardByNo", no);
	}

	public int insertBoard(SqlSession session, Board board) {

		return session.insert("boardMapper.insertBoard", board);
	}

	public int updateBoard(SqlSession session, Board board) {

		return session.update("boardMapper.updateBoard", board);
	}

	public int updateStatus(SqlSession session, int no, String status) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("no", no);
		map.put("status", status);
		
		return session.update("boardMapper.updateStatus", map);
	}
}