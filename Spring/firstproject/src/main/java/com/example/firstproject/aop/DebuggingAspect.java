package com.example.firstproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect	//AOP 클래스 선언 : 부가 기능을 주입하는 클래스
@Component
@Slf4j
public class DebuggingAspect {
	
    @Pointcut("execution(* com.example.firstproject.service.CommentService.*(..))")
	private void cut() {
		
	}
    
    @Before("cut()")
    public void loggingArgs(JoinPoint joinPoint)
    {
    	 Object[] args = joinPoint.getArgs();
    	 
    	 String className = joinPoint.getTarget().getClass().getSimpleName();
    	 
    	 String methodName= joinPoint.getSignature().getName();
    	 
    	 for(Object obj:args)
    	 {
    		 log.info("{}#{}의 입력값 => {}",className,methodName,obj);
    	 }
    }
    
    
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void loggingReturnValue(JoinPoint joinPoint,Object returnObj)
    {
    	
    	String className = joinPoint.getTarget().getClass().getSimpleName();
    	
    	String methodName=joinPoint.getSignature().getName();
    	
    	log.info("{}#{}의 반환값 =>{}",className,methodName,returnObj);
    }
}
