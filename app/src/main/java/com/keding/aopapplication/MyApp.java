package com.keding.aopapplication;

import android.app.Application;

import com.keding.aopapplication.dynamicproxy.Time;
import com.keding.aopapplication.dynamicproxy.TimeStaticHandler;
import com.keding.aopapplication.dynamicproxy.TimeStaticInterface;

import java.lang.reflect.Proxy;

/**
 * @author: skd
 * @date 2019-05-26
 * @Desc MyApp
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        initNetWork();
//        initMap();
//        initPush();
//        TimeStaticInterface proxy = (TimeStaticInterface) Proxy.newProxyInstance(this.getClass().getClassLoader(),
//                new Class[]{TimeStaticInterface.class}, new TimeStaticHandler(this));
//        proxy.timeStatic();
    }
    @Time
    private void initPush() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Time
    private void initMap() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Time
    private void initNetWork() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
