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
<title>교수 조회</title>
<script src="${ path }/js/jquery-3.7.1.js"></script>
<script src="${ path }/js/university.js"></script>
</head>
<body>
	<h2>TB_PROFESSOR 테이블에서 데이터 조회 (비동기 통신)</h2>
	
	<label for="professorNo">교수 번호 : </label>
	<input type="text" id="professorNo">
	<button id="btnSearch">조회</button>
	
	<p id="result"></p>
	
	<script>
		$(document).ready(() => {
			$('#btnSearch').on('click', () => {
				let professorNo = $('#professorNo').val();
				
				university.getProfessorByNo(professorNo, (obj) => {
					let result = '';
					let professor = obj.professor;
						
					console.log(professor);
					
					if (professor !== null) {
						let department = professor.department;
							
						result = '교수 번호 : ' + professor.no + 
						         '<br>이름 : ' + professor.name + 
						         '<br>주소 : ' + professor.address + 
						         '<br>주민 번호 : ' + professor.ssn;
						
						if (department !== null) {
							result += '<br>계열 : ' + department.category +
							          '<br>학과 : ' + department.name;
						} else {
							result += '<br>학과 : 없음';
						}
					} else {
						result = '교수 정보가 없습니다.';
					}
					
					$('#result').html(result);
				});
			});
		});
	</script>
</body>
</html>