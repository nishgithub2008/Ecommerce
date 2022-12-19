package com.sprinbootdemo_ecommerce.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	private static Logger logger = Logger.getLogger(MyAspect.class);

	@Pointcut("execution(* com.sprinbootdemo_ecommerce.controller..*.*(..))||execution(* com.sprinbootdemo_ecommerce.service..*.*(..))||execution(* com.sprinbootdemo_ecommerce.Repository..*.*(..))")

	public void log() {

	}

	@Around(value = "log()")
	public Object intercept(ProceedingJoinPoint pjp) throws Throwable

	{
		System.out.println("Logger");

		String name = pjp.getSignature().getName();
		try {
			logger.info("started " + name);
			Object obj = pjp.proceed();
			logger.info("finished " + name + " successfully");
			return obj;
		} catch (Throwable t) {
			logger.error(name + " finished with Exception - " + t.getMessage());
			throw t;
		}
	}
}