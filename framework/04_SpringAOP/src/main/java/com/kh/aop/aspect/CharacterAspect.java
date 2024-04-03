package com.kh.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CharacterAspect {
	@Pointcut("execution(* com.kh.aop.character.Character.quest(..)) && args(questName)")
	public void questPointcut(String questName) {
	}
	
//	@Before("questPointcut(questName)")
	public void beforeQuest(String questName) {
		System.out.println(questName + " 퀘스트 준비 중..");
	}
	
//	@After("execution(* com.kh.aop.character.Character.quest(..)) and args(questName)")
	public void afterQuest(String questName) {
		System.out.println(questName + " 퀘스트 수행 완료..");
	}
	
//	@AfterReturning(
//		pointcut = "questPointcut(questName)",
//		returning = "result"
//	)
	public void success(String questName, String result) {
		System.out.println("result : " + result );
		System.out.println(questName + " 퀘스트 수행 완료..");		
	}
	
//	@AfterThrowing(
//		pointcut = "questPointcut(questName)",
//		throwing = "exception"
//	)
	public void fail(String questName, Exception exception) {
		System.out.println("message : " + exception.getMessage());
		System.out.println(questName + " 퀘스트 수행 중 에러가 발생했습니다.");		
	}
	
	@Around("execution(* com.kh.aop.character.Character.quest(..))")
	public String around(ProceedingJoinPoint joinPoint) {
		String result = null;
		String questName = (String) joinPoint.getArgs()[0];
		
		try {
			// before 어드바이스에 대한 기능을 수행
			System.out.println(questName + " 퀘스트 준비 중..");
			
			// 타겟 객체의 메소드를 실행시킨다.
			result = (String) joinPoint.proceed();
			
			System.out.println(result);
			
			// after-returning 어드바이스에 대한 기능을 수행
			System.out.println(questName + " 퀘스트 수행 완료..");
			
		} catch (Throwable e) {
			// after-throwing 어드바이스에 대한 기능을 수행
			System.out.println(questName + "퀘스트 수행 중 에러가 발생..");
		}
		
		return result;
	}
}