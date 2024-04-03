package com.kh.ajax.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jqAjax.do")
public class JqueryAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JqueryAjaxServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("input");
    	
		System.out.println(input);
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().printf(
			"입력 값 : %s, 길이 : %d",
			input,
			input.length()
		);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().printf(
			"이름 : %s, 나이 %s",
			userName,
			userAge
		);
	}
}