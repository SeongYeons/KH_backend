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
<title>담당 교수 지정</title>
<script src="${ path }/js/jquery-3.7.1.js"></script>
<script src="${ path }/js/university.js"></script>
</head>
<body>
	<h2>TB_CLASS_PROFESSOR 테이블에 데이터 추가</h2>
	
	<form action="${ path }/subject/join" method="post">
		<security:csrfInput/>
		<label for="deptNo">학과 : </label>
		<select id="deptNo" required>			
			<option>------ 선택 ------</option>
			<c:forEach var="department" items="${ departments }">
				<option value="${ department.no }">
					<c:out value="${ department.name }"/>
				</option>
			</c:forEach>
		</select>
		
		<br><br>
		
		<label for="classNo">과목 : </label>
		<select name="classNo" id="classNo" required>
			<option>------ 선택 ------</option>
		</select>
	
		<br><br>
		
		<label for="professorNo">교수 : </label>
		<select name="professorNo" id="professorNo" required>
			<option>------ 선택 ------</option>
		</select>
		
		<br><br>
		
		<input type="submit" value="등록">
		<input type="reset" value="취소">	
	</form>
	
	<script>
		$(document).ready(() => {
			$('#deptNo').on('change', (event) => {
				let departmentNo = $(event.target).val();
				
				university.getSubjectsByDepartmentNo(departmentNo, (obj) => {
					let element = $('#classNo'); 
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
				
				university.getProfessorsByDepartmentNo(departmentNo, (obj) => {
					let element = $('#professorNo');
					let professors = obj.professors;
					
					console.log(professors);
					
					element.empty();
					element.append('<option value="">------ 선택 ------</option>');
					
					for (let i = 0; i < professors.length; i++) {
						element.append(
							'<option value="' + professors[i].no + '">' + 
								professors[i].name + 
							'</option>'
						);
					} 
				});
			});
		});
	</script>
</body>
</html>