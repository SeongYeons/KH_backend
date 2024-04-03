package com.kh.mvc.member.model.service;

import com.kh.mvc.member.model.vo.Member;

public interface MemberService {

	Member login(String userId, String userPwd);

	int save(Member member);

	Boolean isDuplicateId(String userId);

	Member findMemberById(String userId);

	int delete(int no);

}
