package com.example.yinhen.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.yinhen.project1.adapter.FitnessDiaryAdapter;
import com.example.yinhen.project1.base.BaseActivity;
import com.example.yinhen.project1.libs.Constants;
import com.example.yinhen.project1.libs.Preference;
import com.example.yinhen.project1.models.FitnessDiary;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FitnessDiaryActivity extends BaseActivity {

    public static final int REQUEST_ADD = 5001;

    @BindView(R.id.recyclerView_fitness_diary)
    RecyclerView recyclerViewFitnessDiary;

    FitnessDiaryAdapter fitnessDiaryAdapter;

    List<FitnessDiary> fitnessDiaryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_diary);
        ButterKnife.bind(this);
        setView();
    }

    private void setView() {
        fitnessDiaryList = getDB().fitnessDiaryDao().getAll();
        fitnessDiaryAdapter = new FitnessDiaryAdapter(this, fitnessDiaryList, new FitnessDiaryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FitnessDiary item, int position) {

            }
        });
        recyclerViewFitnessDiary.setAdapter(fitnessDiaryAdapter);
        recyclerViewFitnessDiary.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.button_add)
    public void onViewClicked() {
        if (getDB().fitnessRecordDao().getAll().size() == 0) {
            Toast.makeText(this, "無相關紀錄", Toast.LENGTH_SHORT).show();
        } else if (getDB().fitnessRecordDao().getByDate(
                new Date(Preference.getLong(this, Constants.PREF_LAST_DATE, getDB().fitnessRecordDao().getMinDate())).getTime()
                , new Date().getTime()).size() == 0) {
            Toast.makeText(this, "無相關紀錄", Toast.LENGTH_SHORT).show();
        } else {
            startActivityForResult(new Intent(FitnessDiaryActivity.this, FitnessDiaryAddActivity.class), REQUEST_ADD);
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_ADD) {
                setView();
            }
        }
    }
}
