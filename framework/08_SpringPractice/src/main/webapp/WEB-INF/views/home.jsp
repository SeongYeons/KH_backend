<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/>

<html>
<head>
	<title>스프링 MVC 실습</title>
</head>
<body>
<h2>스프링 MVC 실습</h2>

<P>  The time on the server is ${serverTime}. </P>

<h3>교수 관련 메뉴</h3>
<ul>
	<li><a href="${ path }/professor/search">교수 조회</a></li>
	<li><a href="${ path }/professor/enroll">교수 등록</a></li>
</ul>

<h3>과목 관련 메뉴</h3>
<ul>
	<li><a href="${ path }/subject/enroll">과목 등록</a></li>
	<li><a href="${ path }/subject/join">담당 교수 지정</a></li>
</ul>
</body>