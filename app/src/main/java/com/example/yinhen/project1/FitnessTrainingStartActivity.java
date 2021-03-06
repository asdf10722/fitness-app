package com.example.yinhen.project1;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yinhen.project1.base.BaseActivity;
import com.example.yinhen.project1.libs.Utils;
import com.example.yinhen.project1.models.FitnessRecord;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FitnessTrainingStartActivity extends BaseActivity {

    String[] itemTitle;

    int ItemCount1;
    int ItemCount2;
    int ItemCount3;
    int ItemCount4;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.text_item1)
    TextView textItem1;
    @BindView(R.id.text_item_count1)
    TextView textItemCount1;
    @BindView(R.id.text_item2)
    TextView textItem2;
    @BindView(R.id.text_item_count2)
    TextView textItemCount2;
    @BindView(R.id.text_item3)
    TextView textItem3;
    @BindView(R.id.text_item_count3)
    TextView textItemCount3;
    @BindView(R.id.text_item4)
    TextView textItem4;
    @BindView(R.id.text_item_count4)
    TextView textItemCount4;
    @BindView(R.id.imageView)
    ImageView imageView;

    int position = 0;
    @BindView(R.id.button_next)
    Button buttonNext;
    @BindView(R.id.text_time)
    TextView textTime;

    private TextView[] textItemCount;
    private TextView[] textItem;

    Handler handler = new Handler();

    int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_training_start);
        ButterKnife.bind(this);
        getData();
        setView();
    }

    Runnable updateTime = new Runnable() {
        @SuppressLint("DefaultLocale")
        @Override
        public void run() {
            textTime.setText(String.format("%d分%02d秒", time / 60, time % 60));
            time++;
            handler.postDelayed(updateTime, 1000);
        }
    };

    public void getData() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            itemTitle = bundle.getStringArray("itemTitle");
            if (itemTitle == null) finish();
            if (itemTitle.length > 0)
                ItemCount1 = Integer.parseInt(bundle.getString("ItemCount1"));
            if (itemTitle.length > 1)
                ItemCount2 = Integer.parseInt(bundle.getString("ItemCount2"));
            if (itemTitle.length > 2)
                ItemCount3 = Integer.parseInt(bundle.getString("ItemCount3"));
            if (itemTitle.length > 3)
                ItemCount4 = Integer.parseInt(bundle.getString("ItemCount4"));
        }
        handler.post(updateTime);
    }

    @SuppressLint("DefaultLocale")
    private void setView() {
        textItem = new TextView[]{textItem1, textItem2, textItem3, textItem4};
        textItemCount = new TextView[]{textItemCount1, textItemCount2, textItemCount3, textItemCount4};
        if (itemTitle.length > 0) {
            textItem1.setText(itemTitle[0]);
            textItemCount1.setText(String.format("%d次", ItemCount1));
        }
        if (itemTitle.length > 1) {
            textItem2.setText(itemTitle[1]);
            textItemCount2.setText(String.format("%d次", ItemCount2));
        }
        if (itemTitle.length > 2) {
            textItem3.setText(itemTitle[2]);
            if (itemTitle[2].equals("平板撐體") )
                textItemCount3.setText(String.format("%d秒", ItemCount3));
            else textItemCount3.setText(String.format("%d次", ItemCount3));
        }
        if (itemTitle.length > 3) {
            textItem4.setText(itemTitle[3]);
            if (itemTitle[3].equals("平板撐體"))
                textItemCount4.setText(String.format("%d秒", ItemCount4));
            else textItemCount4.setText(String.format("%d次", ItemCount4));
        }
        updateCurrentTraining();
    }

    private void updateCurrentTraining() {
        Glide.with(this)
                .load(Utils.trainingTypeToImageDrawableID(itemTitle[position]))
                .into(imageView);
        textTitle.setText(itemTitle[position]);
        for (int i = 0; i < itemTitle.length; i++) {
            textItem[i].setTextColor(getResources().getColor(R.color.grey_500));
            textItemCount[i].setTextColor(getResources().getColor(R.color.grey_500));
        }
        textItem[position].setTextColor(getResources().getColor(R.color.black));
        textItemCount[position].setTextColor(getResources().getColor(R.color.black));
        if (position == itemTitle.length - 1) {
            buttonNext.setText("結束");
        }
    }

    @OnClick(R.id.button_next)
    public void onViewClicked() {
        if (position < itemTitle.length - 1) {
            position++;
            updateCurrentTraining();
        } else {
            handler.removeCallbacks(updateTime);
            final double calories = ((double) time / 60.0) * 9.4;
            @SuppressLint("DefaultLocale")
            String message =
                    String.format("本次運動時間: %d分%02d秒\n", time / 60, time % 60) +
                            String.format("總計消耗熱量: %.2f大卡", calories);
            new AlertDialog.Builder(this)
                    .setTitle("健身完成")
                    .setMessage(message)
                    .setNegativeButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getDB().fitnessRecordDao().insertAll(new FitnessRecord(new Date().getTime(), calories));
                            setResult(RESULT_OK, getIntent());
                            finish();
                        }
                    }).show();
        }
    }
}
