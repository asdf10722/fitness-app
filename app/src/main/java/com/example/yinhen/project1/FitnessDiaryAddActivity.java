package com.example.yinhen.project1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yinhen.project1.base.BaseActivity;
import com.example.yinhen.project1.libs.Constants;
import com.example.yinhen.project1.libs.Preference;
import com.example.yinhen.project1.libs.Utils;
import com.example.yinhen.project1.models.FitnessDiary;
import com.example.yinhen.project1.models.FitnessRecord;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class FitnessDiaryAddActivity extends BaseActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private static final int RESULT_LOAD_IMG = 3001;

    @BindView(R.id.text_week)
    TextView textWeek;
    @BindView(R.id.text_date)
    TextView textDate;
    @BindView(R.id.edit_weight)
    EditText editWeight;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.text_save_calorie)
    TextView textSaveCalorie;
    @BindView(R.id.edit_content)
    EditText editContent;

    Calendar calendarCurrent;
    Calendar calendarLast;

    private int week;

    double sum;

    Bitmap selectedImage = null;

    Uri selectedUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_diary_add);
        ButterKnife.bind(this);
        setView();
    }

    @SuppressLint("DefaultLocale")
    private void setView() {
        calendarCurrent = Calendar.getInstance();
        calendarLast = Calendar.getInstance();
        calendarLast.setTime(new Date(Preference.getLong(this, Constants.PREF_LAST_DATE, getDB().fitnessRecordDao().getMinDate())));
        week = calendarCurrent.get(Calendar.WEEK_OF_YEAR) - calendarLast.get(Calendar.WEEK_OF_YEAR);
        textWeek.setText(String.format("%s ~", Utils.convertDate(calendarLast.getTime())));
        Log.e("calendarCurrent", Utils.convertDate(calendarCurrent.getTime()));
        Log.e("calendarLast", Utils.convertDate(calendarLast.getTime()));
        textDate.setText(Utils.convertDate(calendarCurrent.getTime()));
        List<FitnessRecord> fitnessRecordList = getDB().fitnessRecordDao().getByDate(calendarLast.getTimeInMillis(), calendarCurrent.getTimeInMillis());
        sum = calculateSum(fitnessRecordList);
        textSaveCalorie.setText(String.format("省下:%f大卡", sum));
    }

    private double calculateSum(List<FitnessRecord> fitnessRecordList) {
        double sum = 0;
        for (FitnessRecord fitnessRecord : fitnessRecordList) {
            sum += fitnessRecord.getCalorie();
        }
        return sum;
    }

    @OnClick({R.id.button_select_image, R.id.button_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_select_image:
                callImagePicker();
                break;
            case R.id.button_add:
                try {
                    double weight = Double.parseDouble(editWeight.getText().toString());
                    String content = editContent.getText().toString();
                    FitnessDiary fitnessRecord = new FitnessDiary(
                            calendarLast.getTimeInMillis(),
                            calendarCurrent.getTimeInMillis(),
                            weight,
                            sum,
                            content,
                            selectedUri == null ? null : selectedUri.toString());
                    getDB().fitnessDiaryDao().insertAll(fitnessRecord);
                    Preference.setLong(FitnessDiaryAddActivity.this, Constants.PREF_LAST_DATE, calendarCurrent.getTimeInMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(FitnessDiaryAddActivity.this, "錯誤", Toast.LENGTH_LONG).show();
                    return;
                } finally {
                    Toast.makeText(FitnessDiaryAddActivity.this, "成功", Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
                break;
        }
    }

    private void callImagePicker() {
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            //未取得權限，向使用者要求允許權限
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            READ_EXTERNAL_STORAGE},
                    REQUEST_EXTERNAL_STORAGE
            );
            return;
        }
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        callImagePicker();
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                selectedUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(selectedUri);
                selectedImage = BitmapFactory.decodeStream(imageStream);
                image.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(FitnessDiaryAddActivity.this, "錯誤", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(FitnessDiaryAddActivity.this, "您沒有選擇照片", Toast.LENGTH_LONG).show();
        }
    }
}
