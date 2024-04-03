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
<!-- csrf 토큰 정보를 meta에 추가하는 액션 태그 -->
<security:csrfMetaTags/>
<title>교수 등록</title>
<script src="${ path }/js/jquery-3.7.1.js"></script>
<script src="${ path }/js/university.js"></script>
</head>
<body>
	<h2>TB_PROFESSOR 테이블에 데이터 저장</h2>
	
	<label for="name">이름 : </label>
	<input type="text" id="name">
	
	<br><br>
	
	<label for="ssn">주민번호 : </label>
	<input type="text" id="ssn">
	
	<br><br>
	
	<label for="address">주소 : </label>
	<input type="text" id="address">
	
	<br><br>
	
	<label for="departmentNo">학과 : </label>
	<select id="departmentNo">
		<c:forEach var="department" items="${ departments }">
			<option value="${ department.no }">
				<c:out value="${ department.name }"/>
			</option>
		</c:forEach>
	</select>
	
	<br><br>
	
	<button id="btnEnroll">등록</button>
	<button id="btnCancel">취소</button>
	
	<script>
		let headerName = $('meta[name="_csrf_header"]').attr('content');
		let token = $('meta[name="_csrf"]').attr('content');
		
		// 해당 페이지에서 발생하는
		// 모든 AJAX 요청 시 CSRF 토큰을 전송하도록 설정한다.
		$(document).ajaxSend((event, xhr, option) => {
			xhr.setRequestHeader(headerName, token);
		});
				
		$(document).ready(() => {
			$('#btnEnroll').on('click', () => {
				let professor = {
					name: $('#name').val(),
					ssn: $('#ssn').val(),
					address: $('#address').val(),
					departmentNo: $('#departmentNo').val()
				};
				
				university.addProfessor(professor, (obj) => {
					if (obj.resultCode === 1) {
						alert('등록 성공');
					} else {
						alert('등록 실패');
					}
					
					location.reload();
				});
			});
		});
	</script>
</body>
</html>









