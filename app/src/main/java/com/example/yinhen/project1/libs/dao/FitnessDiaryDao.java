package com.example.yinhen.project1.libs.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yinhen.project1.models.FitnessDiary;

import java.util.List;

/**
 * Created by Ray on 2017/10/31.
 */

@Dao
public interface FitnessDiaryDao {

    @Query("SELECT * FROM FitnessDiary")
    List<FitnessDiary> getAll();

    @Query("SELECT * FROM FitnessDiary WHERE id IN (:userIds)")
    List<FitnessDiary> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM FitnessDiary Where id IN (:id)")
    FitnessDiary getByID(int id);

    @Query("SELECT * FROM FitnessDiary Where date IN (:date)")
    List<FitnessDiary> getByDate(String date);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(FitnessDiary... FitnessDiarys);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<FitnessDiary> FitnessDiarys);

    @Delete
    void delete(FitnessDiary FitnessDiary);

    @Delete
    void delete(List<FitnessDiary> FitnessDiaryList);
}
