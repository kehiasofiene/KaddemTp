package tn.esprit.sofienekehia.Aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class logingaspect {
    @Before("execution(* tn.esprit.sofienekehia.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
    log.info("in method:"+ joinPoint.getSignature().getName());
    }
}
