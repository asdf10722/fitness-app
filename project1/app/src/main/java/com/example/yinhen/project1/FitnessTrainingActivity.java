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
