package com.example.yinhen.project1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yinhen.project1.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NutritionalExaminationActivity extends BaseActivity {

    @BindView(R.id.editText8)
    EditText editText8;


    String[] itemTitle;
    @BindView(R.id.button10)
    Button button10;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.editText9)
    EditText editText9;
    @BindView(R.id.textView10)
    TextView textView10;
    @BindView(R.id.editText10)
    EditText editText10;
    @BindView(R.id.textView11)
    TextView textView11;
    @BindView(R.id.editText11)
    EditText editText11;
    @BindView(R.id.textView14)
    TextView textView14;
    @BindView(R.id.button11)
    Button buttonBack;
    @BindView(R.id.activity_main3)
    RelativeLayout activityMain3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritional_examination);
        ButterKnife.bind(this);
        getData();
        setView();
    }

    public void getData() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            // type = bundle.getString("type");
        }

    }

    private void setView() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            itemTitle = bundle.getStringArray("itemTitle");
        }


        buttonBack = (Button) findViewById(R.id.button11);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("DefaultLocale")
            @Override

            public void onClick(View v) {
                //TODO 自動產生的方法 Stub
                try {
                    String a = editText8.getText().toString();
                    String b = editText9.getText().toString();
                    String c = editText10.getText().toString();
                    int ai = Integer.parseInt(a);
                    int bi = Integer.parseInt(b);
                    int ci = Integer.parseInt(c);
                    int sum = ai - bi + ci;
                    editText11.setText(String.format("%d", sum));
                } catch (Exception e) {
                    editText11.setText(String.format("%d", 0));
                }
            }
        });
    }
}

