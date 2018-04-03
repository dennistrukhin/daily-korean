package com.whitekittyapps.dailykorean;

import android.app.Application;

import com.whitekittyapps.dailykorean.DAO.ApplicationDatabase;
import com.whitekittyapps.dailykorean.entities.User;

import java.util.Date;

public class DailyKoreanApp extends Application {

    protected static DailyKoreanApp INSTANCE;
    protected ApplicationDatabase db;
    protected User user;

    public static DailyKoreanApp get()
    {
        return INSTANCE;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        db = ApplicationDatabase.getDatabase(this.getApplicationContext());
        INSTANCE = this;

        registerUser();
    }

    private void registerUser()
    {
        user = db.userModel().getUser();
        if (user == null) {
            user = new User();
            user.setDtStart(new Date());
            user.setDtLastVisit(new Date());
            db.userModel().insert(user);
        } else {
            user.setDtLastVisit(new Date());
            db.userModel().update(user);
        }
    }

    public User getUser() {
        return user;
    }
}
