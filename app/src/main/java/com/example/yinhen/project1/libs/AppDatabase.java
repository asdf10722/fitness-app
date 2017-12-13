package com.example.yinhen.project1.libs;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.yinhen.project1.libs.dao.FitnessDiaryDao;
import com.example.yinhen.project1.libs.dao.FitnessRecordDao;
import com.example.yinhen.project1.models.FitnessDiary;
import com.example.yinhen.project1.models.FitnessRecord;

/**
 * Created by Ray on 2017/10/31.
 */

@Database(entities = {
        FitnessRecord.class,
        FitnessDiary.class},
        version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FitnessDiaryDao fitnessDiaryDao();
    public abstract FitnessRecordDao fitnessRecordDao();
}