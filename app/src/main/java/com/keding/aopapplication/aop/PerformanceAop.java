package com.keding.aopapplication.aop;


import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PerformanceAop {

    @Around("call(* com.keding.aopapplication.MyApp.**(..))")
    public void getTime(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.toShortString();
        long time = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log.i("skd-getTime",name + " cost " + (System.currentTimeMillis() - time));
    }

    @Around("execution(* android.app.Activity.setContentView(..))")
    public void getSetContentViewTime(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.toShortString();
        long time = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log.i("skdskd",name + " cost " + (System.currentTimeMillis() - time));
    }



}
