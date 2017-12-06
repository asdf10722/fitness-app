package com.example.yinhen.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yinhen.project1.base.BaseActivity;

import butterknife.ButterKnife;

public class SettingCaloriesActivity extends BaseActivity {

    private Button button7, button8, button9, button10, button14, button15;
    private EditText editText, editText4, editText2, editText3, editText5,
            editText6, editText7, editText8, editText9, editText10;
    double height, height2, weight, BMI, weight2, weight3, age, BMR1, BMR2;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_calories);
        initView();
        ButterKnife.bind(this);
        setView();
        //CharSequence editText=editText7.getText();
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final String[] lunch = {"正常", "輕度", "中度", "重度", "極重度"};
        ArrayAdapter<String> lunchList = new ArrayAdapter<>(SettingCaloriesActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                lunch);
        spinner2.setAdapter(lunchList);


        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        final String[] lunch3 = {"男", "女"};
        ArrayAdapter<String> lunch3List = new ArrayAdapter<>(SettingCaloriesActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                lunch3);
        spinner3.setAdapter(lunch3List);


        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingCaloriesActivity.this, "回上頁", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(SettingCaloriesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                // TODO Auto-generated method stub
                //DecimalFormat nf = new DecimalFormat(“0.00″);

                height = Double.parseDouble(editText2.getText().toString()) / 100;
                height2 = Double.parseDouble(editText2.getText().toString());
                weight = Double.parseDouble(editText3.getText().toString());
                age = Double.parseDouble(editText5.getText().toString());
                weight2 = Double.parseDouble(editText3.getText().toString()) * 0.9;
                weight3 = Double.parseDouble(editText3.getText().toString()) * 1.1;
                BMI = weight / (height * height);
                editText4.setText(String.format("%.2f", BMI));
                editText8.setText(String.format("%.2f", weight2) + "~" + String.format("%.2f", weight3));
                BMR1 = (13.7 * weight) + (5 * height2) - (6.8 * age) + 66;
                BMR2 = (9.6 * weight) + (1.7 * height2) - (4.7 * age) + 655;


                if (spinner3.getSelectedItemId() == 0) {
                    editText6.setText(String.valueOf(String.format("%.2f", BMR1)));

                    if (spinner2.getSelectedItemId() == 0) {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR1 * 1.2)));
                    } else if (spinner2.getSelectedItemId() == 1) {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR1 * 1.375)));
                    } else if (spinner2.getSelectedItemId() == 2) {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR1 * 1.55)));
                    } else if (spinner2.getSelectedItemId() == 3) {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR1 * 1.725)));
                    } else {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR1 * 1.9)));
                    }
                } else {
                    editText6.setText(String.valueOf(String.format("%.2f", BMR2)));

                    if (spinner2.getSelectedItemId() == 0) {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR2 * 1.2)));
                    } else if (spinner2.getSelectedItemId() == 1) {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR2 * 1.375)));
                    } else if (spinner2.getSelectedItemId() == 2) {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR2 * 1.55)));
                    } else if (spinner2.getSelectedItemId() == 3) {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR2 * 1.725)));
                    } else {
                        editText7.setText(String.valueOf(String.format("%.2f", BMR2 * 1.9)));
                    }

                }


            }


        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SettingCaloriesActivity.this, SettingMenuActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("editText7", editText7.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // TODO Auto-generated method stub
                //DecimalFormat nf = new DecimalFormat(“0.00″);
                if (editText2 != null || editText3 != null || editText4 != null || editText5 != null || editText6 != null
                        || editText7 != null || editText8 != null) {
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText6.setText("");
                    editText7.setText("");
                    editText8.setText("");
                } else {
                    return;

                }

            }
        });


    }

    private void initView() {
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        button9 = (Button) findViewById(R.id.button9);
    }

    private void setView() {
        editText7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingCaloriesActivity.this, "按鈕點擊", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(SettingCaloriesActivity.this, FitnessTrainingActivity.class);
                intent.putExtra("type", "建議熱量");
                startActivity(intent);
            }
        });
    }
    }





