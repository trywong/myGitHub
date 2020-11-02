package com.wc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect {  
  
    public void doAfter(JoinPoint jp) {  
        System.out.println("方法结束之后: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
    }  
  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
        long time = System.currentTimeMillis();  
        Object retVal = pjp.proceed();  
        time = System.currentTimeMillis() - time;  
        System.out.println("耗费: " + time + " ms");
        return retVal;  
    }  
  
    public void doBefore(JoinPoint jp) {  
        System.out.println("方法开始之前: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
    }  
  
    public void doThrowing(JoinPoint jp, Throwable ex) {  
        System.out.println("方法 " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " 抛异常了");
        System.out.println(ex.getMessage());  
    }  
} 