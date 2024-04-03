package com.kh.mybatis.member.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.kh.mybatis.member.model.vo.Member;

@DisplayName("MemberService 테스트")
@TestMethodOrder(OrderAnnotation.class)
class MemberServiceTest {
	private MemberService service;
	
//	모든 테스트 메소드들이 실행되기 전에 실행되는 메소드이다.
//	@BeforeAll
//	public static void init() {
//		System.out.println("init() - 호출");
//	}
	
//	모든 테스트 메소드들이 실행된 후에 실행되는 메소드이다.
//	@AfterAll
//	public static void afterAll() {
//		System.out.println("afterAll() - 호출");
//	}	
	
	// 테스트 메소드들이 실행되기 전에 실행되는 메소드이다.
	@BeforeEach
	void setUp() {
		service = new MemberServiceImpl();
	}
	
	// 테스트 메소드들이 실행된 후에 실행되는 메소드이다.
//	@AfterEach
//	void tearDown() {
//		System.out.println("tearDown() - 호출");
//	}

	@Test
	@Disabled
	void nothing() {
	}
	
	@Test
	@Disabled
	@DisplayName("MemberService 생성 테스트")
	void create() {
		assertThat(service).isNotNull();
	}
	
	@Test
	@Order(1)
	@DisplayName("회원 수 조회 테스트")
	void getMemberCountTest() {
		int count = 0;
		
		count = service.getMemberCount();
		
//		System.out.println(count);
		
		assertThat(count).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	@DisplayName("모든 회원 조회 테스트")
	void findAllTest() {
		List<Member> members = null;
		
		members = service.findAll();
		
//		System.out.println(members);
//		System.out.println(members.size());
		
		assertThat(members).isNotNull().isNotEmpty();
	}
	
	@ParameterizedTest
	@Order(3)
	@ValueSource(strings = {"ismoon", "admin"})
	@DisplayName("회원 조회 테스트(ID로 검색)")
	void findMemberByIdTest(String id) {
		Member member = null;
				
		member = service.findMemberById(id);
		
//		System.out.println(member);
		
//		assertThat(member).isNotNull();
//		assertThat(member.getId()).isEqualTo("ismoon");
		
		assertThat(member).isNotNull()
						  .extracting("id")
						  .isEqualTo(id);
	}
	
	@ParameterizedTest
	@CsvSource(value = {
		"test1, 1234, 임꺽정",
		"test2, 4567, 이몽룡"
	})
	@Order(4)
	@DisplayName("회원 등록 테스트")
	void insertMemberTest(String id, String password, String name) {
		int result = 0;
		Member member = new Member(id, password, name);
				
		result = service.save(member);
		
		assertThat(result).isGreaterThan(0);
		assertThat(member.getNo()).isGreaterThan(0);
	}
	
	@ParameterizedTest
	@CsvSource({
		"test1, 9999, 성춘향",
		"test2, 0000, 심청이"
	})
	@Order(5)
	@DisplayName("회원 정보 수정 테스트")
	void updateMemberTest(String id, String password, String name) {
		int result = 0;
		Member member = service.findMemberById(id);
		
		member.setName(name);
		member.setPassword(password);
		
		result = service.save(member);
		
		assertThat(result).isGreaterThan(0);
		// 실제로 DB에 Member가 수정되었는지 확인하기 위해서 다시 Member를 조회
		assertThat(service.findMemberById(id).getName())
			.isEqualTo(name);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"test1", "test2"})
	@Order(6)
	@DisplayName("회원 삭제 테스트")
	void deleteMemberTest(String id) {
		int result = 0;
		Member member = service.findMemberById(id);
		
		result = service.delete(member.getNo());
		
		assertThat(result).isGreaterThan(0);
		// 실제 DB에서 Member가 삭제되었는지 확인
		assertThat(service.findMemberById(id)).isNull();
	}
}