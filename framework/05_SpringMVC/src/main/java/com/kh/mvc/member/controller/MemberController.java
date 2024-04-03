package com.kh.mvc.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// @RestController
// Model 객체에 loginMember라는 키값으로 Attribute를
// 추가하면 해당 Attribute가 세션 영역에 추가된다. 
@SessionAttributes("loginMember")
public class MemberController {
	// 컨트롤러가 처리할 요청을 정의한다.(URL, Method 등)
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@GetMapping("/login")
//	@PostMapping("/login")
//	public String login() {
//		
//		log.info("login() - 호출");
//		
//		return "home";
//	}
	
//	사용자의 파라미터를 전송받는 방법
//	1. HttpServletRequest 통해서 전송받기
//	@PostMapping("/login")
//	public String login(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//		String userPwd = request.getParameter("userPwd");
//		
//		log.info("login() - 호출({}, {})", userId, userPwd);
//				
//		return "home";
//	}
	
//	2.1. @RequestParam 통해서 전송받는 방법 
//	  - 스프링에서는 간편하게 파라미터를 받아올 수 있는 방법을 제공한다.
//	  - 매개변수의 이름과 파라미터의 name 속성의 값이 동일하면 
//	    @RequestParam을 생략할 수 있다.
//	@PostMapping("/login")
////	public String login(@RequestParam("userId") String id, @RequestParam("userPwd") String password) {
////	public String login(@RequestParam String userId, @RequestParam String userPwd) {
//	public String login(String userId, String userPwd) {
//		
////		log.info("login() - 호출({}, {})", id, password);
//		log.info("login() - 호출({}, {})", userId, userPwd);
//		
//		return "home";
//	}

//	2.2. @RequestParam의 required 속성과 defaultValue 속성
//	  - 실제 존재하지 않는 파라미터를 받으려고 하면 에러가 발생한다.
//	    (required = true)
//	  - required = false로 지정하면 에러가 아닌 null 값을 넘겨준다.
//	  - defaultValue 속성을 사용하면 에러없이 defaultValue에 
//	    지정된 값을 받아올 수 있다.
//	@PostMapping("/login")
//	public String login(
//			@RequestParam String userId,
//			@RequestParam String userPwd,
////			@RequestParam(required = false) String address) {
//			@RequestParam(defaultValue = "서울특별시") String address) {
//		
//		log.info(
//			"login() 호출 - {}, {}, {}", 
//			new Object[] {userId, userPwd, address}
//		);
//		
//		return "home";
//	}
	
//	3. 객체 타입으로 파라미터를 전송받는 방법
//	  - 요청 파리미터가 많은 경우 객체 타입으로 파라미터를 넘겨받는 방법이다.
//	@PostMapping("/login")
//	public String login(Member member) {
//	
//		log.info(member.toString());
//		
//		return "home";
//	}
	
//	4. URL 파라미터를 전송받는 방법
//	  - URL 경로상에 있는 특정 값을 가져오기 위해 사용하는 방법이다.
//	@GetMapping("/member/{id}")
////	public String getMember(@PathVariable("id") int id) {
//	public String getMember(@PathVariable int id) {
//		
//		log.info("getMember() 호출 - {}", id);
//		
//		return "home";
//	}
	
	/*
	 * 로그인 처리
	 * 1. HttpSession과 Model 객체 사용
	 *   - Model은 컨트롤러에서 데이터를 뷰로 전달할 때 사용하는 객체이다.
	 *   - 데이터를 맵 형식(key, value)으로 담을 수 있다.
	 *   - Model 객체의 Scope는 Request이다.
	 */
	@Autowired
	private MemberService service;
	
//	@PostMapping("/login")
//	public String login(
//			HttpSession session,
//			Model model,
//			@RequestParam String userId,
//			@RequestParam String userPwd) {
//		
//		log.info("login() 호출 - {}, {}", userId, userPwd);
//		
//		Member loginMember = service.login(userId, userPwd);
//		
//		System.out.println(loginMember);
//		
//		if(loginMember != null) {
//			session.setAttribute("loginMember", loginMember);
//			
//			return "redirect:/";
//		} else {
//			model.addAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다.");
//			model.addAttribute("location", "/");
//			
//			return "common/msg";
//		}
//	}
	
	/*
	 * 2. @SessionAttributes과 ModelAndView 객체를 사용
	 *   - @SessionAttributes("키값")은 Model 객체에서
	 *     "키값"에 해당하는 Attribute를 Session 영역까지 
	 *     범위를 확장시키는 어노테이션이다.
	 *   - ModelAndView 컨트롤러에서 뷰로 전달할 데이터와
	 *     뷰에 대한 정보를 담는 객체이다.
	 */
	@PostMapping("/login")
	public ModelAndView login(
				ModelAndView modelAndView,
				@RequestParam String userId,
				@RequestParam String userPwd) {
		
		log.info("login() 호출 - {}, {}", userId, userPwd);
	
		Member loginMember = service.login(userId, userPwd);
		
		if (loginMember != null) {
			modelAndView.addObject("loginMember", loginMember);
			modelAndView.setViewName("redirect:/");
		} else {
			modelAndView.addObject("msg", "아이디나 비밀번호가 일치하지 않습니다.");
			modelAndView.addObject("location", "/");
			modelAndView.setViewName("common/msg");
		}
		
		return modelAndView;
	}
	
	
	/*
	 * 로그아웃 처리
	 * 1. HttpSession 객체 사용
	 */
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		
//		session.invalidate();
//		
//		return "redirect:/";
//	}
	
	/*
	 * 2. SessionStatus 객체 사용
	 */
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		
		// 세션 영역으로 확장된 Attribute를 지워준다.
		status.setComplete();
		
		return "redirect:/";
	}
	
	// 회원 가입
	@GetMapping("/member/enroll")
	public String enroll() {
		log.info("enroll() 호출 - 회원 가입 페이지 요청");
		
		return "member/enroll";
	}
	
	@PostMapping("/member/enroll")
	public ModelAndView enroll(
			ModelAndView modelAndView, Member member) {
		log.info("enroll() 호출 - 회원 가입 요청");
				
		int result = service.save(member);
		
		if (result > 0) {
			modelAndView.addObject("msg", "회원 가입 성공");
			modelAndView.addObject("location", "/");
		} else {
			modelAndView.addObject("msg", "회원 가입 실패");
			modelAndView.addObject("location", "/member/enroll");
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	/*
	 * @ResponseBody
	 *   - 컨트롤러 메소드의 반환형이 String일 경우 뷰의 이름을 반환한다.
	 *   - @ResponseBody 붙인 메소드의 반환형이 String일 경우
	 *     해당 요청을 보낸 클라이언트에 전달할 데이터를 의미한다.
	 *     
	 * jackson 라이브러리
	 *   - 자바 객체를 JSON 문자열로 변환하는 라이브러리이다.
	 *   - 스프링에서 jackson 라이브러리를 추가하고 @ResponseBody을
	 *     사용하면 메소드에서 리턴하는 객체를 자동으로 JSON 문자열로
	 *     변환해서 반환한다.
	 *     
	 * @RestController
	 *   - 해당 어노테이션이 붙은 컨트롤러의 모든 메소드에서 
	 *     데이터를 반환하는 경우에 사용한다.
	 *   - @Controller, @ResponseBody를 합쳐놓은 역할을 
	 *     수행한다.
	 */
	
	@GetMapping("/jsonTest")
	@ResponseBody
	public Object jsonTest() {
		
//		return "Hello World!!";
		return new Member("ismoon", "19283746", "문인수");
	}
	
	/*
	 * HttpEntity
	 *   - 스프링 프레임워크에서 제공하는 클래스로 HTTP 요청 또는
	 *     응답에 해당하는 HTTP Header와 HTTP Body를 포함하는 
	 *     클래스이다.
	 *     
	 * ResponseEntity
	 *   - HttpEntity를 상속하는 클래스로 HTTP 응답 데이터를 포함하는
	 *     클래스이다.
	 *   - 개발자가 직접 HTTP Body, Header, Status Code를 
	 *     설정해서 반환할 수 있다.
	 */
	@GetMapping("/member/idCheck")
	public ResponseEntity<Map<String, Boolean>> idCheck(@RequestParam String userId) {
		Map<String, Boolean> map = new HashMap<>();
		
		log.info("UserId : {}", userId);
		
		map.put("duplicate", service.isDuplicateId(userId));
		
		return ResponseEntity.ok()
//						 .header("Content-Type", "application/json")
						 .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
						 .body(map);
//		return new ResponseEntity<Map<String,Boolean>>(map, HttpStatus.OK);
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	// 회원 정보 수정
	// 메소드의 리턴 타입이 void일 경우 Mapping URL을 
	// 유추해서 뷰를 찾는다.
	@GetMapping("/member/myPage")
	public void myPage() {
		log.info("myPage() 호출 - 마이페이지 요청");
	}
	
	@PostMapping("/member/update")
	public ModelAndView update(
			ModelAndView modelAndView,
			Member member,
			@SessionAttribute("loginMember") Member loginMember) {
		
		member.setNo(loginMember.getNo());
		
		int result = service.save(member);
		
		if (result > 0) {
			// 회원 정보 수정 완료
			modelAndView.addObject("loginMember", service.findMemberById(loginMember.getId()));
			modelAndView.addObject("msg", "회원 정보 수정 완료");
		} else {
			// 회원 정보 수정 실패
			modelAndView.addObject("msg", "회원 정보 수정 실패");
		}
		
		modelAndView.addObject("location", "/member/myPage");
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	// 회원 삭제
	@GetMapping("/member/delete")
	public ModelAndView delete(
			ModelAndView modelAndView,
			@SessionAttribute("loginMember") Member loginMember) {
		
		int result = service.delete(loginMember.getNo());
		
		if (result > 0) {
			modelAndView.addObject("msg", "정상적으로 탈퇴되었습니다.");
			modelAndView.addObject("location", "/logout");			
		} else {
			modelAndView.addObject("msg", "탈퇴에 실패하였습니다.");
			modelAndView.addObject("location", "/member/myPage");			
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}