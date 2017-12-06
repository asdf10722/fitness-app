package com.example.yinhen.project1.base;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.blankj.utilcode.util.Utils;
import com.example.yinhen.project1.libs.AppDatabase;

/**
 * Created by Ray on 2017/12/7.
 */

public class BaseApplication extends Application {

    AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        initRoomDatabase();
    }

    private void initRoomDatabase() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
    }

    public AppDatabase getDB() {
        return db;
    }
}
