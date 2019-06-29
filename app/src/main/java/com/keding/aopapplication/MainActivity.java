package com.keding.aopapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.keding.aopapplication.dynamicproxy.Time;
import com.keding.aopapplication.dynamicproxy.TimeStaticHandler;
import com.keding.aopapplication.dynamicproxy.TimeStaticInterface;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimeStaticInterface proxy = (TimeStaticInterface) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{TimeStaticInterface.class}, new TimeStaticHandler(this));
        proxy.timeStatic();

    }

    @Time
    private void method1() {
        SystemClock.sleep(200);
    }

    @Time
    private void method2() {
        SystemClock.sleep(300);
    }
}
