package com.kh.mybatis;

import org.apache.ibatis.session.SqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kh.mybatis.common.template.SqlSessionTemplate;


@DisplayName("첫 번째 테스트 코드 작성")
public class AppTest { 
    @Test
    @Disabled // 테스트 메소드를 비활성
    public void nothing() {
    	// 현재 프로젝트가 테스트 가능한 환경인지 확인한다.
    }
    
    @Test
    @DisplayName("SqlSession 생성 테스트")
    public void create() {
    	int count = 0;
    	SqlSession session = SqlSessionTemplate.getSession();
    	
    	count = session.selectOne("memberMapper.selectCount");
    	
//    	System.out.println(count);
    	
    	assertThat(session).isNotNull();
    	assertThat(count).isGreaterThanOrEqualTo(2);
    }
}