package com.kh.security.member.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.security.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String login() {
		log.info("로그인 페이지 요청");
		
		return "login";
	}
	
	@GetMapping("/admin/view")
	// 2. Authentication를 매개변수로 얻어오는 방법
//	public String adminView(Authentication authentication) {
	// 3. @AuthenticationPrincipal 사용하는 방법
	public String adminView(@AuthenticationPrincipal Member loginMember) {
	
		log.info("관리자 페이지 요청");
		
		// 1. SecurityContextHolder 사용하는 방법
//		Authentication authentication 
//			= SecurityContextHolder.getContext().getAuthentication();
		
//		Member loginMember = 
//				(Member) authentication.getPrincipal();
		
		System.out.println(loginMember);
		
		
		return "admin/view";
	}
	
	@GetMapping("/accessError")
	public String accessError() {
		
		log.info("권한 오류 페이지 요청");
		
		return "accessError";
	}
}