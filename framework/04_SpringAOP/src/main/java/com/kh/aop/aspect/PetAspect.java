package com.kh.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PetAspect {
//	@Around("execution(* com.kh.aop.pet.Dog.bark())")
//	@Around("execution(* com.kh.aop.pet.Pet.bark())")
//	@Around("execution(* com.kh.aop.pet.*.bark())")
//	@Around("execution(* com.kh.aop.pet.*.bark()) && !bean(cat)")
	@Around("execution(* com.kh.aop.pet.*.bark()) && !@annotation(com.kh.aop.annotation.NoLogging)")
	public String barkAdvice(ProceedingJoinPoint joinPoint) {
		String result = null;
				
		try {
			System.out.println("안녕~?");
			
			result = (String) joinPoint.proceed();
			
			System.out.println(result);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
