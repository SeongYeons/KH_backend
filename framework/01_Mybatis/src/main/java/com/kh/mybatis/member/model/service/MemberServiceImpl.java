package com.kh.mybatis.member.model.service;

import static com.kh.mybatis.common.template.SqlSessionTemplate.getSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberServiceImpl implements MemberService {

	@Override
	public int getMemberCount() {
		int count = 0;
		SqlSession session = getSession();
		
		count = new MemberDao().getMemberCount(session);
		
		log.debug("회원 수 : " + count);
		
		session.close();
		
		return count;
	}

	@Override
	public List<Member> findAll() {
		List<Member> members = null;
		SqlSession session = getSession();
		
		members = new MemberDao().findAll(session);
		
		log.info("findAll() - 호출");
		
		session.close();
		
		return members;
	}

	@Override
	public Member findMemberById(String id) {
		Member member = null;
		SqlSession session = getSession();
		
		log.debug("아이디 : " + id);
		
		member = new MemberDao().findMemberById(session, id);
		
		session.close();
		
		return member;
	}

	@Override
	public int save(Member member) {
		int result = 0;
		SqlSession session = getSession();
		
		log.debug("사용자 번호 : {}, 사용자 이름: {}"
				, member.getNo(), member.getName());
		
		if (member.getNo() > 0) {
			// update
			result = new MemberDao().updateMember(session, member);
		} else {
			// insert
			result = new MemberDao().insertMember(session, member);
		}
		
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	@Override
	public int delete(int no) {
		int result = 0;
		SqlSession session = getSession();
		
		result = new MemberDao().delete(session, no);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
}
