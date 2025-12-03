package com.test.inventory.demo.log;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.test.inventory.demo.controller..*(..))")
    public Object logApi(ProceedingJoinPoint joinPoint) throws Throwable {
        
        logger.info("REQUEST: {} with args={}", joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
        
        Object result = joinPoint.proceed();
        
        logger.info("RESPONSE: {}", result);

        return result;
    }
}
