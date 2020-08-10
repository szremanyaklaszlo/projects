package com.training.sportsbetting.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMethodAspects {

    private final static Logger LOG = LoggerFactory.getLogger(ServiceMethodAspects.class);
    private long startTime;
    private long endTime;

    @Pointcut("execution(* com.training.sportsbetting.service.*.*(..)))")
    public void allServiceMethod() {
    };

    @Before("allServiceMethod()")
    public void methodParams(JoinPoint joinPoint) {
        Object[] methodParams = joinPoint.getArgs();
        if(methodParams.length == 0) {
            LOG.debug(methodDescription(joinPoint) + " No input parameter ");
        }else {
            LOG.debug(methodDescription(joinPoint) + " Input parameters: " + Arrays.toString(methodParams));
        }
    }

    @AfterReturning(value = "allServiceMethod()", returning = "returnObject")
    public void returnValue(JoinPoint joinPoint, Object returnObject) {
        if (returnObject != null) {
            LOG.debug(methodDescription(joinPoint) + " Return value: " + returnObject.toString());
        }else {
            LOG.debug(methodDescription(joinPoint) + " No return value ");
        }
    }

    @After(value = "allServiceMethod()")
    public void executionTime(JoinPoint joinPoint) {
        LOG.debug(methodDescription(joinPoint) + " Execution time: " + (endTime - startTime) + "ms");
    }

    @Before("allServiceMethod()")
    public void startTime(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
    }

    @After(value = "allServiceMethod()")
    public void endTime(JoinPoint joinPoint) {
        endTime = System.currentTimeMillis();
    }

    private String methodDescription(JoinPoint joinPoint) {
        String targetClass = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        return "After: Class: " + targetClass + " Method: " + methodName;
    }

}
