package com.diegomalone.amarotest.base;

import android.app.Application;

import timber.log.BuildConfig;
import timber.log.Timber;

public class AmaroApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
