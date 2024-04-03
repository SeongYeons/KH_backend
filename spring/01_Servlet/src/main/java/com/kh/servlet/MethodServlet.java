package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/method.do")
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MethodServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 사용자가 보낸 데이터들은 request 객체를 통해서 얻어올 수 있다.
    	// getParameter("name 속성의 값")
    	//  - 해당 name 속성의 값을 가지는 요소의 value 값을 문자열로 얻어온다.
    	String userName = request.getParameter("userName");
    	String userAge = request.getParameter("userAge");
    	String gender = request.getParameter("gender");
    	
    	// 체크박스와 같이 하나의 name 속성에 여러 값이 존재하는 경우
    	// request.getParameterValues("name 속성의 값") 메소드를 사용한다.
    	//  - 해당 name 속성의 값을 가지는 요소들의 value 값들을 문자열의 
    	//    배열로 얻어온다.
    	String[] foods = request.getParameterValues("food");
    	
    	System.out.println(userName);
    	System.out.println(userAge);
    	System.out.println(gender);
    	Arrays.stream(foods).forEach(System.out::println);
    	
    	// 응답 화면 출력
    	response.setContentType("text/html;charset=UTF-8");
    	
    	PrintWriter out = response.getWriter();

    	out.write("<html>");
    	out.write("<head>");
    	out.write("<title>개인 정보 출력</title>");
    	out.write("</head>");
    	out.write("<body>");
    	out.write("<h2>개인 정보 출력</h2>");
    	out.printf("%s님은 %s세 %s입니다.<br>", userName, userAge, gender);
    	out.write("좋아하는 음식은 ");
    	Arrays.stream(foods).forEach(food -> out.print(food + " "));
    	out.write("입니다.");
    	out.write("</body>");
    	out.write("</html>");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// POST 방식의 경우 클라이언트에서 보내주는 데이터를
    	// 요청 body에 포함해서 전달한다.
    	
    	// 요청 body에 포함되어 전달되는 값들은 기본적으로 
    	// ISO-8859-1로 인코딩 되어 전달되는데 request에서 
    	// 파라미터 값을 가져오기 전에 UTF-8로 인코딩 설정을 해야 한다.
    	request.setCharacterEncoding("UTF-8");
    	
    	doGet(request, response);
	}
    
    
    
    
    
    
    
    
    
    
    
    
    

}
