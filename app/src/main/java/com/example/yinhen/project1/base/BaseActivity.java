package com.example.yinhen.project1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.yinhen.project1.libs.AppDatabase;

/**
 * Created by Ray on 2017/9/18.
 */

public class BaseActivity extends AppCompatActivity {

    BaseApplication application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initApp();
    }

    public void initApp() {
        application = (BaseApplication) getApplication();
    }

    public BaseApplication getBaseApplication() {
        return application;
    }

    public AppDatabase getDB() {
        return ((BaseApplication) getApplication()).getDB();
    }
}
