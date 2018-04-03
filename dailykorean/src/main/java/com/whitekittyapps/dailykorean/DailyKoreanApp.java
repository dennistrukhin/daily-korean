package com.whitekittyapps.dailykorean;

import android.app.Application;

import com.whitekittyapps.dailykorean.DAO.ApplicationDatabase;
import com.whitekittyapps.dailykorean.entities.User;

import java.time.ZoneId;
import java.util.Date;

public class DailyKoreanApp extends Application {

    protected static DailyKoreanApp INSTANCE;
    protected ApplicationDatabase db;
    protected User user;

    public static DailyKoreanApp get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        db = ApplicationDatabase.getDatabase(this.getApplicationContext());
        INSTANCE = this;

        registerUser();
    }

    private void registerUser() {
        user = db.userModel().getUser();
        if (user == null) {
            user = new User();
            user.setDtStart(new Date());
            user.setDtLastVisit(new Date());
            user.setWordsShown(0);
            db.userModel().insert(user);
        } else {
            Date lastVisit = user.getDtLastVisit();
            Date currentVisit = new Date();
            if (currentVisit.getYear() > lastVisit.getYear()
                    || currentVisit.getMonth() > lastVisit.getMonth()
                    || currentVisit.getDay() > lastVisit.getDay()) {
                user.setWordsShown(user.getWordsShown() + 1);
            }
            user.setDtLastVisit(new Date());
            db.userModel().update(user);
        }
    }

    public User getUser() {
        return user;
    }

}
