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
<title>과목 등록</title>
<script src="${ path }/js/jquery-3.7.1.js"></script>
<script src="${ path }/js/university.js"></script>
</head>
<body>
	<h2>TB_CLASS 테이블에 데이터 추가</h2>
	
	<form id="enrollForm" action="${ path }/subject/enroll" method="post">
		<label for="deptNo">학과 : </label>
		<select name="deptNo" id="deptNo" required>			
			<option>------ 선택 ------</option>
			<c:forEach var="department" items="${ departments }">
				<option value="${ department.no }">
					<c:out value="${ department.name }"/>
				</option>
			</c:forEach>
		</select>
		
		<br><br>
		
		<label for="preattendingNo">선수 과목 : </label>
		<select name="preattendingNo" id="preattendingNo">
			<option>------ 선택 ------</option>
		</select>
		
		<br><br>
		
		<label for="name">과목 이름 : </label>
		<input type="text" name="name" id="name" required>
		
		<br><br>
		
		<label>과목 구분</label>
		<input type="text" name="type" id="type" list="subjectTypeList">
		
		<datalist id="subjectTypeList">
			<option value="논문지도">논문지도</option>
			<option value="전공필수">전공필수</option>
			<option value="전공선택">전공선택</option>
			<option value="교양필수">교양필수</option>
			<option value="교양선택">교양선택</option>
		</datalist>
		
		<br><br>
		
		<security:csrfInput/>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
	
	<script>
		$(document).ready(() => {
			$('#enrollForm').on('submit', () => {
				if ($('#preattendingNo').val() === '') {
					$('#preattendingNo').prop('disabled', true);
				}
				
				if($('#type').val() === '') {
					$('#type').prop('disabled', true);
				}
			});
			
			$('#deptNo').on('change', (event) => {
				let departmentNo = $(event.target).val();
				
				university.getSubjectsByDepartmentNo(departmentNo, (obj) => {
					let element = $('#preattendingNo'); 
					let subjects = obj.subjects;
					
					console.log(subjects);
					
					element.empty();
					element.append('<option value="">------ 선택 ------</option>');
					
					for (let i = 0; i < subjects.length; i++) {
						element.append(
							'<option value="' + subjects[i].no + '">' + 
								subjects[i].name + 
							'</option>'
						);
					} 
				});
			});
		});	
	</script>
</body>
</html>