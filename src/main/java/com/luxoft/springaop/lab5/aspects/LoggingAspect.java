package com.luxoft.springaop.lab5.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Log
public class LoggingAspect {
	@Pointcut("execution(* *.set*(..))")
	public void setterMethod() {
	}

	@Around("setterMethod() ")
	public Object setterLogger(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		String methodName = thisJoinPoint.getSignature().getName();
		Object[] methodArgs = thisJoinPoint.getArgs();
		StringBuilder args = new StringBuilder();
		for (Object arg: methodArgs) {
			if (args.length() > 0) {
				args.append(", ");
			}
			args.append(arg.toString());
		}
		log.info(String.format("Call method %s with args %s", methodName, args));
		Object result = thisJoinPoint.proceed();
		log.info(String.format("Method %s returns %s", methodName, result));
		return result;
	}
}
