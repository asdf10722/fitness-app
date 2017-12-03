package com.example.yinhen.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FitnessTrainingStartActivity extends AppCompatActivity {

    String[] itemTitle;

    int ItemCount1;
    int ItemCount2;
    int ItemCount3;
    int ItemCount4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_training_start);
        getData();
    }

    public void getData() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            itemTitle = bundle.getStringArray("itemTitle");
            if (itemTitle == null) finish();
            if (itemTitle.length > 0)
                ItemCount1 =  Integer.parseInt(bundle.getString("ItemCount1"));
            if (itemTitle.length > 1)
                ItemCount2 =  Integer.parseInt(bundle.getString("ItemCount2"));
            if (itemTitle.length > 2)
                ItemCount3 =  Integer.parseInt(bundle.getString("ItemCount3"));
            if (itemTitle.length > 3)
                ItemCount4 =  Integer.parseInt(bundle.getString("ItemCount4"));
        }
    }
}
