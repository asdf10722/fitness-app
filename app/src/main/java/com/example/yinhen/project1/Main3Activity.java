package com.example.yinhen.project1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Main3Activity extends AppCompatActivity {

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
    Button button11;
    @BindView(R.id.activity_main3)
    RelativeLayout activityMain3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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


        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this, "回上頁", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("type", "建議熱量");
                intent.setClass(Main3Activity.this, MainActivity.class);
                startActivity(intent);
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

