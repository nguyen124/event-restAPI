package com.afs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.afs.controller.*.*(..))")
	private void forControllersPackage() {

	}

	@Pointcut("execution(* com.afs.services.*.*(..))")
	private void forServicesPackage() {

	}

	@Pointcut("execution(* com.afs.dao.*.*(..))")
	private void forDAOPackage() {

	}

	@Pointcut("forControllersPackage() || forServicesPackage() || forDAOPackage()")
	private void forApplication() {

	}

	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("@Before Advice: Calling the method: " + methodName);
	}

	@AfterReturning(pointcut = "forApplication()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toLongString();
		logger.info("@AfterReturning: From Method: " + methodName);
		logger.info("@AfterReturning: Returned Data : " + result);
	}
}
