package com.kh.opendata.student.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.kh.opendata.department.model.service.DepartmentService;
import com.kh.opendata.student.model.service.StudentService;

import lombok.extern.slf4j.Slf4j;

/*
 * 스프링 부트에서 MVC를 테스트할 때 사용하는 어노테이션이다.
 */
@Slf4j
@WebMvcTest(StudentController.class)
class StudentControllerTest {
	/*
	 * 서버를 구동하지 않고 컨트롤러의 동작을 테스트하기 위한 객체(빈)이다.
	 */
	@Autowired
	private MockMvc mockMvc;
	
	/*
	 * @WebMvcTest 어노테이션을 사용하는 경우 테스트 대상 컨트롤러만 빈으로 생성한다.
	 * 따라서 컨트롤러에서 사용하는 서비스 빈은 Mock 객체로 만들어야 한다.
	 * 
	 * @MockBean 어노테이션은 스프링 부트에서 
	 * 테스트 대상 컨트롤러와 관련된 빈을 Mock 객체로 만들어서 자동으로 주입하는데 사용된다.
	 */
	@MockBean
	private StudentService studentService;
	
	@MockBean
	private DepartmentService departmentService;

	@Test
	void searchTest() throws Exception {
		
		mockMvc.perform(get("/student/search"))
				.andExpect(status().isOk())
				.andExpect(view().name("student/search"));			
	}
	
	@Test
	void studentsTest () throws Exception {
//		mockMvc.perform(get("/students").param("deptNo", "001").param("absenceYn", "Y"))
		mockMvc.perform(get("/students").param("deptNo", "001"))
			   .andDo(print()) // 요청과 응답 정보를 콘솔에 출력한다.
			   .andExpect(status().isOk());
	}
}