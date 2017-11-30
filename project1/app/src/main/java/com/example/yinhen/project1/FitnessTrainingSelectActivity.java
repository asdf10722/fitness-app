package com.example.yinhen.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FitnessTrainingSelectActivity extends AppCompatActivity {


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
                Toast.makeText(FitnessTrainingSelectActivity.this, "回上頁", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        cardChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FitnessTrainingSelectActivity.this, "按鈕點擊", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(FitnessTrainingSelectActivity.this, FitnessTrainingActivity.class);
                intent.putExtra("type", "胸部");
                startActivity(intent);
            }
        });
    }
}