/**
 * 춘대학 자바스크립트 모듈
 * 모듈 패턴은 관련된 변수 및 함수를 캡슐화할 때 사용하는 패턴이다.(즉시 실행 함수와 클로저 활용)
 */
 
 let university = (() => {
 	let test = 'test';
 	 	
 	// 교수 조회
 	function getProfessorByNo(professorNo, success) {
 		console.log(`Professor NO : ${professorNo}`);
 		
		$.ajax({
			type: 'get',
			url: `/practice/professors/${professorNo}`,
			dataType: 'json',
			success: (obj) => {
				console.log('success');
				
				if(success) {
					success(obj);
				}
			}
		});
 	}
 	
 	// 교수 목록 조회 (학과 번호)
 	function getProfessorsByDepartmentNo(departmentNo, success) {
 		console.log(`Department No : ${departmentNo}`);
 	
 	 	$.getJSON('/practice/professors', { departmentNo })
		 .done((obj) => {
			console.log('done');
			
			if(success) {
				success(obj);
			}
		 });
 	}
 	
 	// 교수 등록
 	function addProfessor(professor, success) {
 		console.log(professor);
 		
		$.ajax({
			type: 'post',
			url: '/practice/professors/enroll',
			data: JSON.stringify(professor),
			dataType: 'json',
			contentType: 'application/json;charset=utf-8',
			success: (obj) => {
				console.log('success');
				
				if (success) {
					success(obj);
				}
			}
		});
 	}
 	
 	// 과목 목록 조회 (학과 번호)
 	function getSubjectsByDepartmentNo(departmentNo, success) {
 		console.log(`Department No : ${departmentNo}`);
 		
 		$.getJSON('/practice/subjects', { departmentNo })
		 .done((obj) => {
			console.log('done');
			
			if(success) {
				success(obj);
			}
		 });
 	}
 
 	return {
 		getProfessorByNo: getProfessorByNo,
 		getProfessorsByDepartmentNo: getProfessorsByDepartmentNo,
 		addProfessor: addProfessor,
 		getSubjectsByDepartmentNo: getSubjectsByDepartmentNo
 	};
 })();