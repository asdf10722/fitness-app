package com.example.yinhen.project1.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yinhen.project1.R;
import com.example.yinhen.project1.libs.Constants;
import com.example.yinhen.project1.libs.Preference;
import com.example.yinhen.project1.libs.Utils;
import com.example.yinhen.project1.models.FitnessDiary;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ray on 2017/12/7.
 */

public class FitnessDiaryAdapter extends RecyclerView.Adapter<FitnessDiaryAdapter.ViewHolder> {

    private Context context;

    private final OnItemClickListener listener;

    private final List<FitnessDiary> contactList;

    public interface OnItemClickListener {
        void onItemClick(FitnessDiary item, int position);
    }

    public FitnessDiaryAdapter(Context context, List<FitnessDiary> contactList, OnItemClickListener listener) {
        this.contactList = contactList;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.list_fitness_diary, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Calendar calendarCurrent = Calendar.getInstance();
        Calendar calendarFirst = Calendar.getInstance();
        calendarCurrent.setTime(new Date(contactList.get(position).getEndDate()));
        calendarFirst.setTime(new Date(Preference.getLong(context, Constants.PREF_FIRST_DATE, new Date().getTime())));
        if (contactList.get(position).getImageUri() != null){
            Uri uri = Uri.parse(contactList.get(position).getImageUri());
            holder.image.setImageURI(uri);
        }
        holder.textWeek.setText(String.format("開始時間: %s", Utils.convertDate(new Date(contactList.get(position).getStartDate()))));
        holder.textDate.setText(String.format("結束時間: %s", Utils.convertDate(new Date(contactList.get(position).getEndDate()))));
        holder.textContent.setText(contactList.get(position).getContent());
        holder.textSaveCalorie.setText(String.format("省下:%.2f大卡", contactList.get(position).getSaveCalorie()));
        holder.textWeight.setText(String.format("體重:%.2f公斤", contactList.get(position).getWeight()));
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_week)
        TextView textWeek;
        @BindView(R.id.text_date)
        TextView textDate;
        @BindView(R.id.text_weight)
        TextView textWeight;
        @BindView(R.id.text_save_calorie)
        TextView textSaveCalorie;
        @BindView(R.id.text_content)
        TextView textContent;
        @BindView(R.id.image)
        ImageView image;

        View mView;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            ButterKnife.bind(this, itemView);
            mView = itemLayoutView;
        }
    }
}
