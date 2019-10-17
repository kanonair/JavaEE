package io.kanonair.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AopDemo {
    /**
     * Spring只能拦截public
     */
    @Around("execution(* io.kanonair.service.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println(point.getSignature().getName());
        System.out.println(Arrays.toString(point.getArgs()));
        System.out.println("环绕前");
        Object o = point.proceed();
        System.out.println("环绕后");
        return o;
    }

}
