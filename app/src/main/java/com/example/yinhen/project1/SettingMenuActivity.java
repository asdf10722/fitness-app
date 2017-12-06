package com.example.yinhen.project1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yinhen.project1.base.BaseActivity;

import java.util.Objects;

public class SettingMenuActivity extends BaseActivity {

    private Button button12, button14,button15;
    private EditText editText13, editText14, editText15;
    double protein, fat, sugar, value;

    final String[] range6 = {"3", "4", "5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_menu);


        Bundle bundle = getIntent().getExtras();
        //String editText=bundle.getString("editText");

        if (bundle != null) {
            //value = Double.parseDouble(bundle.getString("editText"));
            //String editText7=bundle.getString("editText7");
            if (!Objects.equals(bundle.getString("editText7"), ""))
                value = Double.parseDouble(bundle.getString("editText7"));


        } else {
            value = 1;


        }
        final Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        final ArrayAdapter<String> range6List = new ArrayAdapter<>(SettingMenuActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                range6);
        spinner6.setAdapter(range6List);

        button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingMenuActivity.this, "回上頁", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(SettingMenuActivity.this, SettingCaloriesActivity.class);
                startActivity(intent);
            }
        });

        button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingMenuActivity.this, "離開", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(SettingMenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //editText = (EditText) findViewById(R.id.editText);
        editText13 = (EditText) findViewById(R.id.editText13);
        editText14 = (EditText) findViewById(R.id.editText14);
        editText15 = (EditText) findViewById(R.id.editText15);
        protein = value / 4;
        fat = value / 9;
        sugar = value / 4;

        //protein=(1000/4);
        //fat=(1800/9);
        //sugar=(1000/4);

        button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                // TODO Auto-generated method stub
                //DecimalFormat nf = new DecimalFormat(“0.00″);
                int position = (int) spinner6.getSelectedItemId();
                int count = Integer.valueOf(range6[position]);
                Log.d("position", position + "");
                editText13.setText(String.valueOf(String.format("%.2f", protein * 0.25 / count)));
                editText14.setText(String.valueOf(String.format("%.2f", fat * 0.12 / count)));
                editText15.setText(String.valueOf(String.format("%.2f", sugar * 0.63 / count)));


            }

        });
    }
    }
