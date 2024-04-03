<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<h2 style="color: red">에러가 발생했습니다. 관리자에게 문의해 주세요.</h2>
	
	<button onclick="history.go(-1);">이전 페이지로</button>
	
	<%-- 
	<%= exception %>
	<%= exception.getMessage() %>
	<%= exception.getClass().getName() %>
	--%>
</body>
</html>