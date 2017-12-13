package com.example.yinhen.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.example.yinhen.project1.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FitnessTrainingSelectActivity extends BaseActivity {


    @BindView(R.id.card_chest)
    CardView cardChest;
    @BindView(R.id.card_hip)
    CardView cardHip;
    @BindView(R.id.card_arm)
    CardView cardArm;
    @BindView(R.id.card_leg)
    CardView cardLeg;
    @BindView(R.id.card_abdominal)
    CardView cardAbdominal;
    @BindView(R.id.button_back)
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_training_select);
        ButterKnife.bind(this);
        setView();
    }

    private void setView() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        cardChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FitnessTrainingSelectActivity.this, FitnessTrainingActivity.class);
                intent.putExtra("type", "胸部");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });
        cardHip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FitnessTrainingSelectActivity.this, FitnessTrainingActivity.class);
                intent.putExtra("type", "臀部");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });
        cardArm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FitnessTrainingSelectActivity.this, FitnessTrainingActivity.class);
                intent.putExtra("type", "手臂");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });
        cardLeg .setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FitnessTrainingSelectActivity.this, FitnessTrainingActivity.class);
                intent.putExtra("type", "腿部");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });
        cardAbdominal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FitnessTrainingSelectActivity.this, FitnessTrainingActivity.class);
                intent.putExtra("type", "腹部");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });
        }
    }
