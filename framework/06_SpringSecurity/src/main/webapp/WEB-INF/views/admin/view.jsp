<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/>
<security:authentication property="principal" var="loginMember"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>관리자 전용 페이지</h2>
	
	<!--  
	<security:authentication property="principal"/>
	<p><security:authentication property="principal.id"/></p>
	<p><security:authentication property="principal.name"/></p>
	<p><security:authentication property="principal.email"/></p>
	-->
	
	${ loginMember.id }, ${ loginMember.name }, ${ loginMember.email }
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>