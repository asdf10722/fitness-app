package com.example.yinhen.project1.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Arrays;

/**
 * Created by Ray on 2017/12/7.
 */

@Entity
public class FitnessDiary {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "date")
    private long date;

    @ColumnInfo(name = "weight")
    private double weight;

    @ColumnInfo(name = "saveCalorie")
    private double saveCalorie;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "image")
    private byte[] image;

    public FitnessDiary() {
    }

    public FitnessDiary(long date, double weight, double saveCalorie, String content, byte[] image) {
        this.date = date;
        this.weight = weight;
        this.saveCalorie = saveCalorie;
        this.content = content;
        this.image = image;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSaveCalorie() {
        return saveCalorie;
    }

    public void setSaveCalorie(double saveCalorie) {
        this.saveCalorie = saveCalorie;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FitnessDiary{" +
                "id=" + id +
                ", date=" + date +
                ", weight=" + weight +
                ", saveCalorie=" + saveCalorie +
                ", content='" + content + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
