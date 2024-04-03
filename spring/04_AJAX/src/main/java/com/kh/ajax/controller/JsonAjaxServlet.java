package com.kh.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.vo.User;

@WebServlet("/jsonAjax.do")
public class JsonAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonAjaxServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo")); 
		
		// 사용자 정보가 저장되어 있는 List 객체 생성
		List<User> users = new ArrayList<>();
		
		users.add(new User(1, "홍길동", 30, "남자"));
		users.add(new User(2, "김철수", 16, "남자"));
		users.add(new User(3, "김영희", 16, "여자"));
		users.add(new User(4, "이몽룡", 24, "남자"));
		users.add(new User(5, "성춘향", 24, "여자"));
		users.add(new User(6, "영심이", 20, "여자"));
		users.add(new User(7, "왕경태", 20, "남자"));
		
		User findUser = users.stream()
				 .filter(user -> user.getNo() == userNo)
				 .findFirst()
				 .orElse(null);
		
		System.out.println(findUser);
		System.out.println(new Gson().toJson(findUser));
		
		User user = new Gson().fromJson("{\"no\":6,\"name\":\"영심이\",\"age\":20,\"gender\":\"여자\"}", User.class);
		
		System.out.println(user);
		
		response.setContentType("application/json;charset=UTF-8");
		
//		response.getWriter().print(findUser);
		response.getWriter().print(new Gson().toJson(findUser));
	}
}
