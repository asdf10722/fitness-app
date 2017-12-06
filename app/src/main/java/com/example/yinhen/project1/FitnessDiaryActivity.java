package com.example.yinhen.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yinhen.project1.adapter.FitnessDiaryAdapter;
import com.example.yinhen.project1.base.BaseActivity;
import com.example.yinhen.project1.models.FitnessDiary;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FitnessDiaryActivity extends BaseActivity {

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
        startActivity(new Intent(FitnessDiaryActivity.this, FitnessDiaryAddActivity.class));
    }
}
