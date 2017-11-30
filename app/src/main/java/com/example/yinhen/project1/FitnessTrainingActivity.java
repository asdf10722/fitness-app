package com.example.yinhen.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FitnessTrainingActivity extends AppCompatActivity {

    String type;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.text_item1)
    TextView textItem1;
    @BindView(R.id.spinner_item_count1)
    Spinner spinnerItemCount1;
    @BindView(R.id.text_item2)
    TextView textItem2;
    @BindView(R.id.spinner_item_count2)
    Spinner spinnerItemCount2;
    @BindView(R.id.text_item3)
    TextView textItem3;
    @BindView(R.id.spinner_item_count3)
    Spinner spinnerItemCount3;
    @BindView(R.id.text_item4)
    TextView textItem4;
    @BindView(R.id.spinner_item_count4)
    Spinner spinnerItemCount4;
    @BindView(R.id.button_begin)
    Button buttonBegin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_training);
        ButterKnife.bind(this);
        getData();
        setView();
    }

    public void getData() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            type = bundle.getString("type");
        }
        if (type == null) finish();
    }

    private void setView() {
        if (type.equals("胸部")) {
            textTitle.setText("胸部訓練");
            textItem1.setText("伏地挺身");
            final String[] data1 = {"10", "11", "12", "13", "14"};
            setSpinnerData(spinnerItemCount1, data1);
            textItem2.setText("引體向上");
            final String[] data2 = {"10","11","12","13","14"};
            setSpinnerData(spinnerItemCount2, data2);
            textItem3.setText("啞鈴練習");
            final String[] data3 = {"10", "11", "12", "13", "14"};
            setSpinnerData(spinnerItemCount3, data3);
            spinnerItemCount4.setVisibility(View.INVISIBLE);
        }
        else if (type.equals("臀部")) {
            textTitle.setText("臀部訓練");
            textItem1.setText("深蹲");
            final String[] data1 = {"20", "25", "30", "35", "40"};
            setSpinnerData(spinnerItemCount1, data1);
            textItem2.setText("臥姿抬腿");
            final String[] data2 = {"10","15","20","25","30"};
            setSpinnerData(spinnerItemCount2, data2);
            spinnerItemCount3.setVisibility(View.INVISIBLE);
            spinnerItemCount4.setVisibility(View.INVISIBLE);
        }
        else if (type.equals("手臂")) {
            textTitle.setText("手臂訓練");
            textItem1.setText("伏臥撐");
            final String[] data1 = {"5", "6", "7", "8", "9", "10"};
            setSpinnerData(spinnerItemCount1, data1);
            textItem2.setText("爬山式");
            final String[] data2 = {"10", "15", "20", "25", "30"};
            setSpinnerData(spinnerItemCount2, data2);
            textItem3.setText("平板撐體");
            final String[] data3 = {"20", "30", "40", "50", "60"};
            setSpinnerData(spinnerItemCount3, data3);
            spinnerItemCount4.setVisibility(View.INVISIBLE);
        }
        else if (type.equals("腿部")) {
            textTitle.setText("腿部訓練");
            textItem1.setText("屈膝禮弓步");
            final String[] data1 = {"15", "16", "17", "18", "19", "20"};
            setSpinnerData(spinnerItemCount1, data1);
            textItem2.setText("深蹲");
            final String[] data2 = {"20", "25", "30", "35", "40"};
            setSpinnerData(spinnerItemCount2, data2);
            textItem3.setText("側躺抬腿");
            final String[] data3 = {"15", "16", "17", "18", "19","20"};
            setSpinnerData(spinnerItemCount3, data3);
            spinnerItemCount4.setVisibility(View.INVISIBLE);
        }
        else if (type.equals("腹部")) {
            textTitle.setText("腹部訓練");
            textItem1.setText("捲腹");
            final String[] data1 = {"10", "11", "12", "13", "14", "15"};
            setSpinnerData(spinnerItemCount1, data1);
            textItem2.setText("仰臥起坐");
            final String[] data2 = {"10", "11", "12", "13", "14","15"};
            setSpinnerData(spinnerItemCount2, data2);
            textItem3.setText("仰臥舉腿");
            final String[] data3 = {"10", "11", "12", "13", "14","15"};
            setSpinnerData(spinnerItemCount3, data3);
            textItem4.setText("平板撐體");
            final String[] data4 = {"20", "30", "40", "50", "60"};
            setSpinnerData(spinnerItemCount4, data4);
        }
        buttonBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setSpinnerData(Spinner spinner, final String[] data) {
        ArrayAdapter<String> lunchList = new ArrayAdapter<>(FitnessTrainingActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                data);
        spinner.setAdapter(lunchList);
    }
}
