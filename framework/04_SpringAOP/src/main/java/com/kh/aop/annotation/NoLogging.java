package com.kh.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 어노테이션
 *   - JDK5부터 추가된 기능으로 자바 코드에 추가적인 정보를 제공하는 메타 데이터이다.
 *   - 어노테이션은 클래스, 메소드, 생성자, 필드, 매개변수 등에 추가할 수 있다.
 */
// 어노테이션을 적용할 위치(대상)를 지정한다.
@Target(value = {ElementType.METHOD, ElementType.TYPE})
// 어노테이션의 유효 범위를 지정할 때 사용한다.
// RetentionPolicy.SOURCE : 소스 코드상에서만 유효하다.
// RetentionPolicy.CLASS : 클래스를 참조할 때까지 유효하다.
// RetentionPolicy.RUNTIME : JVM에 의해서 참조가 가능하다.
@Retention(RetentionPolicy.RUNTIME)
public @interface NoLogging {
}