package com.whitekittyapps.dailykorean.DAO;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import com.whitekittyapps.dailykorean.DAO.TypeConverter.DateConverter;
import com.whitekittyapps.dailykorean.entities.User;

@android.arch.persistence.room.Database(entities = {User.class}, version = 1)
@TypeConverters(DateConverter.class)
abstract public class ApplicationDatabase extends RoomDatabase {

    private static ApplicationDatabase INSTANCE;

    public abstract UserDAO userModel();

    public static ApplicationDatabase getDatabase(Context context)
    {
        if (INSTANCE == null) {
            INSTANCE = Room
                    .databaseBuilder(context.getApplicationContext(), ApplicationDatabase.class, "daily_korean.db")
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_0_1)
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }

    private static final Migration MIGRATION_0_1 = new Migration(0, 1) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

}
