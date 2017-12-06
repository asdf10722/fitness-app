package com.example.yinhen.project1.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Ray on 2017/12/7.
 */

@Entity
public class FitnessRecord {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "date")
    private long date;

    @ColumnInfo(name = "calorie")
    private double calorie;

    public FitnessRecord() {
    }

    public FitnessRecord(long date, double calorie) {
        this.date = date;
        this.calorie = calorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    @Override
    public String toString() {
        return "FitnessRecord{" +
                "id=" + id +
                ", date=" + date +
                ", calorie=" + calorie +
                '}';
    }
}
