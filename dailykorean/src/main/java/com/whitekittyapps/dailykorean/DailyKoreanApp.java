package com.whitekittyapps.dailykorean;

import android.app.Application;

public class DailyKoreanApp extends Application {

    protected static DailyKoreanApp INSTANCE;

    public static DailyKoreanApp get()
    {
        return INSTANCE;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();

        INSTANCE = this;
    }

}
