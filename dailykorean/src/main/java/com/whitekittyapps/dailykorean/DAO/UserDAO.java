package com.whitekittyapps.dailykorean.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.whitekittyapps.dailykorean.entities.User;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM users LIMIT 1")
    User getUser();

    @Insert(onConflict = IGNORE)
    void insert(User user);

    @Update(onConflict = REPLACE)
    void update(User user);

}
