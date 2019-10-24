package com.luxoft.springaop.lab5.aspects;

import com.luxoft.springaop.lab5.exceptions.ValidationException;
import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Log
@Order(1)
public class ValidationLoggingAspect {
    @Pointcut("execution(* *.setAge(..))")
    public void setAgeMethod() {
    }

    @AfterThrowing(pointcut = "setAgeMethod()", throwing = "e")
    public void validationExceptionLogger(JoinPoint joinPoint, ValidationException e) {
        Object[] methodArgs = joinPoint.getArgs();
        StringBuilder args = new StringBuilder();
        for (Object arg : methodArgs) {
            if (args.length() > 0) {
                args.append(", ");
            }
            args.append(arg.toString());
        }
        String methodName = joinPoint.getSignature().getName();
        log.severe(String.format(
                "ValidationException in method %s with args%s", methodName, args));
    }
}
