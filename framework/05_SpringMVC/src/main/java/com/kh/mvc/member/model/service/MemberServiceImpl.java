package com.kh.mvc.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.mvc.member.model.mapper.MemberMapper;
import com.kh.mvc.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public Member findMemberById(String userId) {
		
		return mapper.selectMemberById(userId);
	}
	
	@Override
	public Member login(String userId, String userPwd) {
		Member member = this.findMemberById(userId);
		
		// 매번 랜덤한 솔트값을 가지고 암호화 하기 때문에 
		// 매번 다른 값으로 암호화 된다.
//		System.out.println(encoder.encode(userPwd));	
		
		// matches 메소드를 사용하면 내부적으로 복호화해서 
		// 나온 결과 값에 솔트값을 땐 나머지 값과 원문을 비교한다.
//		System.out.println(encoder.matches(userPwd, member.getPassword()));
		
		if (member == null || !encoder.matches(userPwd, member.getPassword())) {
			return null;
		}
		
		return member;
	}

	@Override
	@Transactional
	public int save(Member member) {
		int result = 0;
		
		if (member.getNo() > 0) {
			// update
			result = mapper.updateMember(member);
		} else {
			// insert
			member.setPassword(encoder.encode(member.getPassword()));
			
			result = mapper.insertMember(member);
		}
		
//		if(true) {
//			throw new RuntimeException("에러 발생");
//		}
		
		return result;
	}

	@Override
	public Boolean isDuplicateId(String userId) {		
		
		return this.findMemberById(userId) != null;
	}

	@Override
	@Transactional
	public int delete(int no) {
		
		return mapper.updateStatus(no, "N");
	}
}