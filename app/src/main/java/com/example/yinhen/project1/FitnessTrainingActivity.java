package com.example.yinhen.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.yinhen.project1.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FitnessTrainingActivity extends BaseActivity {

    public static final int REQUEST_START = 100;

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

    String[] itemTitle;

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
            itemTitle = new String[]{"伏地挺身", "引體向上", "啞鈴練習"};
            textTitle.setText("胸部訓練");
            final String[] data1 = {"10", "11", "12", "13", "14"};
            setSpinnerData(spinnerItemCount1, data1);
            final String[] data2 = {"10", "11", "12", "13", "14"};
            setSpinnerData(spinnerItemCount2, data2);
            final String[] data3 = {"10", "11", "12", "13", "14"};
            setSpinnerData(spinnerItemCount3, data3);
            spinnerItemCount4.setVisibility(View.INVISIBLE);
        } else if (type.equals("臀部")) {
            itemTitle = new String[]{"深蹲", "臥姿抬臀"};
            textTitle.setText("臀部訓練");
            final String[] data1 = {"20", "25", "30", "35", "40"};
            setSpinnerData(spinnerItemCount1, data1);
            final String[] data2 = {"10", "15", "20", "25", "30"};
            setSpinnerData(spinnerItemCount2, data2);
            spinnerItemCount3.setVisibility(View.INVISIBLE);
            spinnerItemCount4.setVisibility(View.INVISIBLE);
        } else if (type.equals("手臂")) {
            itemTitle = new String[]{"俯臥撐", "爬山式", "平板撐體"};
            textTitle.setText("手臂訓練");
            final String[] data1 = {"5", "6", "7", "8", "9", "10"};
            setSpinnerData(spinnerItemCount1, data1);
            final String[] data2 = {"10", "15", "20", "25", "30"};
            setSpinnerData(spinnerItemCount2, data2);
            final String[] data3 = {"20", "30", "40", "50", "60"};
            setSpinnerData(spinnerItemCount3, data3);
            spinnerItemCount4.setVisibility(View.INVISIBLE);
        } else if (type.equals("腿部")) {
            itemTitle = new String[]{"屈膝禮弓步", "深蹲", "側躺抬腿"};
            textTitle.setText("腿部訓練");
            final String[] data1 = {"15", "16", "17", "18", "19", "20"};
            setSpinnerData(spinnerItemCount1, data1);
            final String[] data2 = {"20", "25", "30", "35", "40"};
            setSpinnerData(spinnerItemCount2, data2);
            final String[] data3 = {"15", "16", "17", "18", "19", "20"};
            setSpinnerData(spinnerItemCount3, data3);
            spinnerItemCount4.setVisibility(View.INVISIBLE);
        } else if (type.equals("腹部")) {
            itemTitle = new String[]{"捲腹", "仰臥起坐", "仰臥舉腿", "平板撐體"};
            textTitle.setText("腹部訓練");
            final String[] data1 = {"10", "11", "12", "13", "14", "15"};
            setSpinnerData(spinnerItemCount1, data1);
            final String[] data2 = {"10", "11", "12", "13", "14", "15"};
            setSpinnerData(spinnerItemCount2, data2);
            final String[] data3 = {"10", "11", "12", "13", "14", "15"};
            setSpinnerData(spinnerItemCount3, data3);
            final String[] data4 = {"20", "30", "40", "50", "60"};
            setSpinnerData(spinnerItemCount4, data4);
        }
        if (itemTitle.length > 0)
            textItem1.setText(itemTitle[0]);
        if (itemTitle.length > 1)
            textItem2.setText(itemTitle[1]);
        if (itemTitle.length > 2)
            textItem3.setText(itemTitle[2]);
        if (itemTitle.length > 3)
            textItem4.setText(itemTitle[3]);
        buttonBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FitnessTrainingActivity.this, FitnessTrainingStartActivity.class);
                intent.putExtra("itemTitle", itemTitle);
                if (itemTitle.length > 0)
                    intent.putExtra("ItemCount1", spinnerItemCount1.getSelectedItem().toString());
                if (itemTitle.length > 1)
                    intent.putExtra("ItemCount2", spinnerItemCount2.getSelectedItem().toString());
                if (itemTitle.length > 2)
                    intent.putExtra("ItemCount3", spinnerItemCount3.getSelectedItem().toString());
                if (itemTitle.length > 3)
                    intent.putExtra("ItemCount4", spinnerItemCount4.getSelectedItem().toString());
                startActivityForResult(intent, REQUEST_START);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });
    }

    private void setSpinnerData(Spinner spinner, final String[] data) {
        ArrayAdapter<String> lunchList = new ArrayAdapter<>(FitnessTrainingActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                data);
        spinner.setAdapter(lunchList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_START) {
            if (resultCode == RESULT_OK) {
                onBackPressed();
            }
        }
    }
}
