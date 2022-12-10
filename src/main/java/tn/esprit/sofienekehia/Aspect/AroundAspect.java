package tn.esprit.sofienekehia.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@Aspect
public class AroundAspect {
    @Around("execution(* tn.esprit.sofienekehia.services.*.getAll*(..))")
    public List<Object> executionTime(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
       List<Object> obj=new ArrayList<Object>();//si le type de retour est une liste
        obj=(List<Object>) pjp.proceed();
        //Object obj = pjp.proceed();
        stopWatch.stop();
        String methodname=pjp.getSignature().getName();
        log.info("The runtime of the method:( " + methodname + "|="+stopWatch.getTotalTimeMillis() + "milisecondes");
        return obj;}
}
