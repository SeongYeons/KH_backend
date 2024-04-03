<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 요소</title>
</head>
<body>
	<h2>JSP 요소</h2>
	
	<!-- HTML 주석 태그 -->
	<%-- JSP 주석 태그--%>
	<%--
		두 주석의 차이점
		  페이지 소스 보기 혹은 개발자 도구에서 HTML 주석은 확인이 
		  가능하고 JSP 주석은 확인이 불가능하다.
	--%>
	
	<%-- 선언문 태그 --%>
	<%!
		// 필드(멤버 변수) 선언
		private String name = "홍길동";
	
		// 메소드 선언
		public String getName() {
			return this.name;
		}
	%>
	
	<%-- 스크립트릿 태그 --%>
	<% 
		// 자바 코드 기술
		int sum = 0;
		
		for (int i = 1; i <= 10; i++) {
			sum += i;
	%>
	<h3>안녕하세요.</h3>
	<%	
		}
		
		System.out.println(sum);
	%>
	
	<%-- 표현식 태그 --%>
	1부터 10까지의 합은 <% out.print(sum); %>입니다.<br>
	1부터 10까지의 합은 <%= sum %>입니다.
</body>
</html>