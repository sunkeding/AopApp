package com.keding.aopapplication;

import android.app.Application;

/**
 * @author: skd
 * @date 2019-05-26
 * @Desc MyApp
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initNetWork();
        initMap();
        initPush();

    }

    private void initPush() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initMap() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initNetWork() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
