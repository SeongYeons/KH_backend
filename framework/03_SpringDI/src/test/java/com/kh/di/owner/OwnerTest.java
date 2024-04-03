package com.kh.di.owner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.di.config.RootConfig;
import com.kh.di.pet.Cat;

/*
 * JUnit에서 스프링을 사용할 수 있도록 SpringExtension를 사용하여 확장한다.
 * @ContextConfiguration()을 통해서 설정 파일을 읽고 애플리케이션 컨텍스트를
 * 생성할 수 있다.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
//	locations = {"classpath:spring/root-context.xml"}
	classes = {RootConfig.class}
)
class OwnerTest {
	@Autowired
	@Qualifier("lim")
	private Owner owner;

	@Test
	void test() {
	}
	
	@Test
	void create() {
    	// 생성자를 통한 의존성 주입
		// 기존에 자바 애플리케이션에서는 다형성을 통해서 객체 간의 결합도를
		// 느슨하게 만들었다.
//        Owner owner = new Owner("홍길동", 25, new Dog("댕댕이"));
//        Owner owner = new Owner("홍길동", 25, new Cat("야옹이"));
		
		Owner owner = new Owner();
		
		// 메소드를 통한 의존성 주입
		owner.setName("이몽룡");
		owner.setAge(23);
//		owner.setPet(new Dog("복희"));
		owner.setPet(new Cat("나비"));
        
        assertThat(owner).isNotNull();
        assertThat(owner.getPet()).isNotNull();
	}
	
	@Test
	void xmlApplicationContextTest() {
//		스프링은 애플리케이션 컨텍스트를 활용하여 객체 간의 결합도를
//		더욱 느슨하게 만든다.
		ApplicationContext context = 
//				기본적으로 클래스 패스를 기준으로 파일을 찾는다.
				new GenericXmlApplicationContext("spring/root-context.xml");
//				new GenericXmlApplicationContext("classpath:spring/root-context.xml");
		
//				직접 파일의 경로를 지정해서 찾는다.
//				new GenericXmlApplicationContext("file:D:/develop/framework/03_SpringDI/src/main/resources/spring/root-context.xml");
		
//		Owner owner = (Owner) context.getBean("hong");
//		Owner owner = context.getBean("hong", Owner.class);
		Owner owner = context.getBean("lee", Owner.class);
		
//		System.out.println(owner);
		
		assertThat(context).isNotNull();
		assertThat(owner).isNotNull();
	}
	
	@Test
	void annotationApplicationContextTest() {
		ApplicationContext context
			= new AnnotationConfigApplicationContext(RootConfig.class);
		
//		Owner owner = context.getBean("lim", Owner.class);
		Owner owner = context.getBean("kim", Owner.class);
		
//		System.out.println(owner);
		
		assertThat(context).isNotNull();
		assertThat(owner).isNotNull();
		assertThat(owner.getPet()).isNotNull();
	}
	
	@Test
	void autowiredTest() {
//		System.out.println(owner);
		
		assertThat(owner).isNotNull();
		assertThat(owner.getPet()).isNotNull();
	}
}
