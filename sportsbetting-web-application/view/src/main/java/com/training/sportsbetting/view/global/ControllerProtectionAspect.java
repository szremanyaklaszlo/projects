package com.training.sportsbetting.view.global;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.sportsbetting.service.user.security.AuthenticationChecker;

@Aspect
@Component
public class ControllerProtectionAspect {

    @Autowired
    private AuthenticationChecker authenticationChecker;

    @Pointcut("execution(* com.training.sportsbetting.view.home.HomeController.getHome(..))")
    public void homeController() {
    };
    
    @Pointcut("execution(* com.training.sportsbetting.view.events.EventsController.getEvents(..))")
    public void eventsController() {
    };

    @Around("homeController() || eventsController()")
    public String resolveUserPages(ProceedingJoinPoint joinPoint) throws Throwable {
        String page = (String) joinPoint.proceed();
        String result;
        if (authenticationChecker.isAuthenticated()) {
            result = page + "-user";
        } else {
            result = page;
        }
        return result;
    }

}
