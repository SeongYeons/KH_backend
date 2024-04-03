package com.kh.mvc.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.mvc.member.model.vo.Member;

@Mapper
public interface MemberMapper {
//	@Select("SELECT COUNT(*) FROM MEMBER")
//	int selectCount();
	
	Member selectMemberById(@Param("id") String id);
	
	int insertMember(Member member);
	
	int updateMember(Member member);
	
	int updateStatus(@Param("no")int no, @Param("status")String status);
	
	
	
	
	
	
	
	
	
}