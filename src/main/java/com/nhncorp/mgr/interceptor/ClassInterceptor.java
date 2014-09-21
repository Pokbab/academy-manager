package com.nhncorp.mgr.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ClassInterceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void interceptor() {
	}
	
	@Before("interceptor()")
	public void doInterceptorBefore(JoinPoint joinPoint) {
		logger.debug("ClassInterceptor:doInterceptorBefore");
		logger.debug("클래스인터셉터 전처리기!!!!");
	}
	
	@After("interceptor()")
	public void doInterceptorAfter(JoinPoint joinPoint) {
		logger.debug("ClassInterceptor:doInterceptorAfter");
		logger.debug("클래스인터셉터 후처리기!!!!");
	}
}
