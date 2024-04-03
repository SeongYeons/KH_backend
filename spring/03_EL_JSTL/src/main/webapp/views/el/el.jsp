<%@ page import="com.kh.el.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h2>EL</h2>
	
	<h3>1. 기존 방식으로 request, session 객체에 담겨있는 데이터를 출력</h3>
	<%-- 
	<%
		Student student = (Student) request.getAttribute("student");
	%>
	강의장 : <%= request.getAttribute("classRoom") %> <br>
	수강생 : <%= ((Student) request.getAttribute("student")).getName() %>
	수강생 : <%= student.getName() %> <br>
	나이 : <%= student.getAge() %>
	
	<br><br>
	
	<%
      	student = (Student) session.getAttribute("student");
    %>
    
    강의장 : <%= session.getAttribute("classRoom") %> <br>
    수강생 : <%= ((Student) session.getAttribute("student")).getName() %> <br> 
    나이  : <%= student.getAge() %>	
	--%>
	
	<h3>2. EL 방식으로 request, session 객체에 담겨있는 데이터를 출력</h3>
	<!-- 
		1. EL은 영역 객체에 저장된 속성명을 검색해서 존재하는 경우 값을 가져온다.
		  - Page 영역 -> Request 영역 -> Session 영역 -> Application 영역
	
		2. EL은 객체의 필드에 직접 접근하는 것처럼 보이지만 내부적으로는
		   해당 객체의 Getter 메소드로 접근해서 값을 읽어온다.
	-->
	강의장 : ${ classRoom }<br>
	수강생 : ${ student.name }<br>
	나이 : ${ student.age }
	
	<br><br>
	
	강의장 : ${ sessionScope.classRoom }<br>
	수강생 : ${ sessionScope.student.name }<br>
	나이 : ${ sessionScope.student.age }
	
	<h3>3. EL 사용 시 영역 객체에 저장된 속성명이 같은 경우</h3>
	<%
		// Page 영역에 데이터를 저장
		pageContext.setAttribute("scope", "Page 영역");
	%>
	
	scope: ${ scope } <br>
	pageScope : ${ pageScope.scope } <br>
	requestScope : ${ requestScope.scope } <br>
	sessionScope : ${ sessionScope.scope } <br>
	applicationScope : ${ applicationScope.scope }
	
	<h3>4. ContextPath 가져오기</h3>
	<h4>1) 표현식 태그를 사용하는 방법</h4>
	contextPath : <%= request.getContextPath() %>
	
	<h4>2) EL을 사용하는 방법</h4>
	conTextPath : ${ pageContext.request.contextPath } <br>
	
	
	<h3>5. 헤더에 접근하기</h3>
	<h4>1) 표현식 태그를 사용하는 방법</h4>
	Host : <%= request.getHeader("Host") %><br>
	User-Agent : <%= request.getHeader("User-Agent") %>
	
	<h4>2) EL을 사용하는 방법</h4>
	Host : ${ header.host }<br>
	User-Agent : ${ header['User-Agent'] }
	
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
</body>
</html>