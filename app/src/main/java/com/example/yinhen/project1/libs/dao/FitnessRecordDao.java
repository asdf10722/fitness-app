package com.example.yinhen.project1.libs.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yinhen.project1.models.FitnessRecord;

import java.util.List;

/**
 * Created by Ray on 2017/10/31.
 */

@Dao
public interface FitnessRecordDao {

    @Query("SELECT * FROM FitnessRecord")
    List<FitnessRecord> getAll();

    @Query("SELECT * FROM FitnessRecord WHERE id IN (:userIds)")
    List<FitnessRecord> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM FitnessRecord Where id IN (:id)")
    FitnessRecord getByID(int id);

    @Query("SELECT * FROM FitnessRecord Where date >= (:startDate) AND date <= (:endDate)")
    List<FitnessRecord> getByDate(long startDate,long endDate);

    @Query("SELECT MIN(date) FROM FitnessRecord")
    long getMinDate();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(FitnessRecord... FitnessRecords);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<FitnessRecord> FitnessRecords);

    @Delete
    void delete(FitnessRecord FitnessRecord);

    @Delete
    void delete(List<FitnessRecord> FitnessRecordList);
}
