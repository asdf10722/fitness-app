package com.example.yinhen.project1.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Ray on 2017/12/7.
 */

@Entity
public class FitnessDiary {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "startDate")
    private long startDate;

    @ColumnInfo(name = "endDate")
    private long endDate;

    @ColumnInfo(name = "weight")
    private double weight;

    @ColumnInfo(name = "saveCalorie")
    private double saveCalorie;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "image")
    private String imageUri;

    public FitnessDiary() {
    }

    public FitnessDiary(long startDate,long endDate, double weight, double saveCalorie, String content, String imageUri) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.weight = weight;
        this.saveCalorie = saveCalorie;
        this.content = content;
        this.imageUri = imageUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
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

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public String toString() {
        return "FitnessDiary{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", weight=" + weight +
                ", saveCalorie=" + saveCalorie +
                ", content='" + content + '\'' +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}
