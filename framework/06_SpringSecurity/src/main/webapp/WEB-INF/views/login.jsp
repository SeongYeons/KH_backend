<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	
	<form action="${ path }/login" method="post">
		<security:csrfInput/>
		
		<label for="userId">아이디 : </label>
		<!--  
		<input type="text" id="userId" name="username" required/>
		-->
		<input type="text" id="userId" name="userId" required/>
		
		<br>
		
		<label for="userPwd">비밀번호 : </label>
		<!--  
		<input type="password" id="userPwd" name="password" required/>
		-->
		<input type="password" id="userPwd" name="userPwd" required/>
		
		<br>
		
		<label>로그인 유지 : </label>
		<input type="checkbox" id="remember-me" name="remember-me">
		
		<br><br>
		
		<input type="submit" value="로그인">
	</form>
	
	<span style="color: red;">${ loginFailMsg }</span>
</body>
</html>