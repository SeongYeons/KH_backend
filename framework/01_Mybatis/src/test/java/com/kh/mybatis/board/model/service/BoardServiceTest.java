package com.kh.mybatis.board.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

@TestMethodOrder(OrderAnnotation.class)
class BoardServiceTest {
	private BoardService service;
	
	@BeforeEach
	void setUp() {
		service = new BoardServiceImpl();
	}

	@Test
	@Disabled
	void nothing() {
	}

	@Test
	@Disabled
	@DisplayName("BoardService 생성 테스트")
	void create() {
		assertThat(service).isNotNull();
	}
	
	@Test
	@Order(1)
	@DisplayName("전체 게시글 수 조회 테스트")
	void getBoardCountTest() {
		int count = 0;
		
		count = service.getBoardCount();
		
//		System.out.println(count);
		
		assertThat(count).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	@DisplayName("게시글 전체 목록 조회 테스트")
	void getBoardListTest() {
		int page = 1;
		PageInfo pageInfo = null;
		List<Board> list = null;
		int listCount = 0;
		
		listCount = service.getBoardCount();
		pageInfo = new PageInfo(page, 10, listCount, 10);		
		list = service.getBoardList(pageInfo);
		
//		System.out.println(list);
//		System.out.println(list.size());
		
		assertThat(list).isNotNull().isNotEmpty();
	}
	
	@ParameterizedTest
	@CsvSource(
		value = {
			"NVL, NVL",
			"writer, is",
			"title, 50",
			"content, 10"
		},
		nullValues = "NVL"
	)
	@Order(3)
	@DisplayName("게시글 목록 조회(검색 기능 적용) 테스트")
	public void getBoardListTest(String type, String keyword) {
		List<Board> list = null;
		PageInfo pageInfo = null;
		int listCount = 0;
		
		listCount = service.getBoardCount(type, keyword);
		pageInfo = new PageInfo(1, 10, listCount, 5);		
		list = service.getBoardList(pageInfo, type, keyword);
		
//		System.out.println(list);
//		System.out.println(listCount);
//		System.out.println(pageInfo.getMaxPage());
//		System.out.println();
		
		assertThat(list).isNotNull().isNotEmpty();
	}
	
	@Test
	@Order(4)
	@DisplayName("게시글 목록 조회(필터 기능 적용) 테스트")
	void getBoardListByFilterTest() {
//		String[] filters = null;
		String[] filters = {"B2", "B3"};
		List<Board> list = null;
		PageInfo pageInfo = null;
		int listCount = 0;
		
		listCount = service.getBoardCount(filters);
		pageInfo = new PageInfo(1, 10, listCount, 5);		
		list = service.getBoardList(pageInfo, filters);
		
//		System.out.println(list);
//		System.out.println(list.size());
//		System.out.println(listCount);
//		System.out.println(pageInfo.getMaxPage());
		
		assertThat(list).isNotNull().isNotEmpty();
	}
	
	@Test
	@Order(5)
	@DisplayName("게시글 상세 조회(댓글 포함) 테스트")
	void getBoardByNo() {
		Board board = null;
		
		board = service.getBoardByNo(108);
		
//		System.out.println(board);
//		System.out.println(board.getReplies());
//		System.out.println(board.getReplies().size());
		
		assertThat(board).isNotNull();
		assertThat(board.getReplies()).isNotNull().isNotEmpty();
	}
	
	@Test
	@Order(6)
	@DisplayName("게시글 등록 테스트")
	void insertBoardTest() {
		int result = 0;
		Board board = null;
		
		board = new Board();
		
		board.setWriterNo(22);
		board.setTitle("mybatis로 게시글 작성");
		board.setContent("mybatis로 작성된 게시글 입니다.");
		board.setOriginalFilename("test.txt");
		board.setRenamedFilename("test.txt");
		
//		System.out.println(board);
		
		result = service.save(board);
		
//		System.out.println(board);
		
		assertThat(result).isGreaterThan(0);
		assertThat(board.getNo()).isGreaterThan(0);
	}
	
	@Test
	@Order(7)
	@DisplayName("게시글 수정 테스트")
	void updateBoardTest() {
		int result = 0;
		Board board = null;
		
		board = service.getBoardByNo(124);
		
		board.setTitle("mybatis 게시글 수정 2");
		board.setContent("mybatis 게시글을 수정하였습니다. 2");
		board.setOriginalFilename(null);
		board.setRenamedFilename(null);
		
		result = service.save(board);
		
		assertThat(result).isGreaterThan(0);
	}
	
	@Test
	@Order(8)
	@DisplayName("게시글 삭제 테스트")
	void deleteBoardTest() {
		int result = 0;
		
		result = service.delete(124);
		
		assertThat(result).isGreaterThan(0);
		assertThat(service.getBoardByNo(124)).isNull();
	}
}
