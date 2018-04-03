package com.whitekittyapps.dailykorean.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "st_start")
    private Date dtStart;

    @ColumnInfo(name = "dt_last_visit")
    private Date dtLastVisit;

    @ColumnInfo(name = "words_shown")
    private int wordsShown;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDtStart() {
        return dtStart;
    }

    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
    }

    public Date getDtLastVisit() {
        return dtLastVisit;
    }

    public void setDtLastVisit(Date dtLastVisit) {
        this.dtLastVisit = dtLastVisit;
    }

    public int getWordsShown() {
        return wordsShown;
    }

    public void setWordsShown(int wordsShown) {
        this.wordsShown = wordsShown;
    }
}
