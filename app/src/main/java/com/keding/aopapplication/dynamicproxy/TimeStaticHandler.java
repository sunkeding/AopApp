package com.keding.aopapplication.dynamicproxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: skd
 * @date 2019-06-29
 * @Desc 统计方法的时间
 */
public class TimeStaticHandler implements InvocationHandler {
    public TimeStaticHandler(Object target) {
        this.target = target;
    }

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Method[] declaredMethods = target.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Time annotation = declaredMethod.getAnnotation(Time.class);
            if (annotation != null) {
                long start = System.currentTimeMillis();
                try {
                    //需要支持private方法,很关键
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(target, args);
                    long end = System.currentTimeMillis();
                    long count = end - start;
                    Log.d("TimeStaticHandler", declaredMethod.getName() + "耗时" + count);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }
}
