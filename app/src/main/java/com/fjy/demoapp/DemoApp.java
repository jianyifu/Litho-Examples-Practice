package com.fjy.demoapp;

import android.app.Application;

import com.facebook.soloader.SoLoader;

public class DemoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
    }
}
