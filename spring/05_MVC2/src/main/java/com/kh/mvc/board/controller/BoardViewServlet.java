package com.kh.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;

@WebServlet(name = "boardView", urlPatterns = { "/board/view" })
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardViewServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int no = Integer.parseInt(request.getParameter("no"));
    	
    	System.out.println("게시글 번호 : " + no);
    	
    	// 새로 고침 시 조회 수가 증가하는 것을 방지하는 로직 
    	// 쿠키에 조회한 게시글의 번호를 기록하여 한 번 조회하면 그 뒤에는 조회 수가 올라가지 않도록 설정
    	// 1. 쿠키에 조회한 이력이 있는지 확인
		Cookie[] cookies = request.getCookies();
		String boardHistory = ""; // 조회한 게시글 번호를 저장하는 변수
		boolean hasRead = false; // 읽은 글이면 true, 안 읽었으면 false
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				// boardHistory인 쿠키 값을 찾기
				if(cookie.getName().equals("boardHistory")) {
					boardHistory = cookie.getValue(); //현재 저장된 값 대입
					
					if(boardHistory.contains("|" + no + "|")) {
						// 읽은 게시글
						hasRead = true;
						 
						break;
					}
				}
			}
		}
		
		// 2. 읽지 않은 게시글이면 cookie에 기록
		if(!hasRead) {
			Cookie cookie = new Cookie("boardHistory", boardHistory + "|" + no + "|");
			
			cookie.setMaxAge(-1); // 브라우저 종료 시 삭제
			response.addCookie(cookie);
		}
    	
    	Board board = new BoardService().getBoardByNo(no, hasRead);
    	
    	request.setAttribute("board", board);
    	request.getRequestDispatcher("/views/board/view.jsp")
    	       .forward(request, response);
	}
}