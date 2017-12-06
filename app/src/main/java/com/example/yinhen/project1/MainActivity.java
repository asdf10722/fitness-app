package com.example.yinhen.project1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.example.yinhen.project1.base.BaseActivity;


public class MainActivity extends BaseActivity {
    private Button buttonSettingMenu, buttonNutritionalExamination, buttonFitnessTraining, buttonTrainingAchievements, buttonExit;
    CardView cardSettingCalories;
    //private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSettingMenu = (Button) findViewById(R.id.button_setting_menu);
        buttonNutritionalExamination = (Button) findViewById(R.id.button_nutritional_examination);
        buttonFitnessTraining = (Button) findViewById(R.id.button_fitness_training);
        buttonTrainingAchievements = (Button) findViewById(R.id.button_training_achievements);
        buttonExit = (Button) findViewById(R.id.button_exit);
        cardSettingCalories = findViewById(R.id.card_set_calories);
        cardSettingCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SettingCaloriesActivity.class);
                startActivity(intent);
            }
        });

        buttonSettingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SettingMenuActivity.class);
                startActivity(intent);
            }
        });

        buttonNutritionalExamination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type", "建議熱量");
                intent.setClass(MainActivity.this, NutritionalExaminationActivity.class);
                startActivity(intent);
            }
        });

        buttonFitnessTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FitnessTrainingSelectActivity.class);
                startActivity(intent);
            }
        });

        buttonTrainingAchievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FitnessDiaryActivity.class);
                startActivity(intent);
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
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
}
