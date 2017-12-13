package com.example.yinhen.project1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.example.yinhen.project1.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @BindView(R.id.card_set_calories)
    CardView cardSetCalories;
    @BindView(R.id.card_set_menu)
    CardView cardSetMenu;
    @BindView(R.id.card_fitness_training)
    CardView cardFitnessTraining;
    @BindView(R.id.card_nutritional_examination)
    CardView cardNutritionalExamination;
    @BindView(R.id.card_training_achievements)
    CardView cardTrainingAchievements;
    @BindView(R.id.card_exit)
    CardView cardExit;
    CardView cardSettingCalories;
    //private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e("data",getDB().fitnessRecordDao().getAll().toString());
        cardSettingCalories = findViewById(R.id.card_set_calories);
        cardSettingCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SettingCaloriesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });

        cardSetMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SettingMenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });

        cardNutritionalExamination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type", "建議熱量");
                intent.setClass(MainActivity.this, NutritionalExaminationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });

        cardFitnessTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FitnessTrainingSelectActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });

        cardTrainingAchievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FitnessDiaryActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });

        cardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("確認視窗")
                        .setMessage("確定要結束應用程式嗎?")
                        //.setIcon(R.drawable.ic_launcher)
                        .setPositiveButton("確定",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        finish();
                                    }
                                })
                        .setNegativeButton("取消",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        // TODO Auto-generated method stub

                                    }
                                }).show();
            }

            //return true;


        });
    }

    @OnClick({R.id.card_set_menu, R.id.card_fitness_training, R.id.card_nutritional_examination, R.id.card_training_achievements, R.id.card_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_set_menu:
                break;
            case R.id.card_fitness_training:
                break;
            case R.id.card_nutritional_examination:
                break;
            case R.id.card_training_achievements:
                break;
            case R.id.card_exit:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
