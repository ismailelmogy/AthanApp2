package com.ismail.athanapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ismail.athanapp.R;
import com.ismail.athanapp.model.Data;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private List<Data> dataList;
    private Context context;

    public CustomAdapter(Context context,List<Data> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView fajr_time,sunrise_time,dhuhr_time,asr_time,sunset_time,maghrib_time, isha_time,imsak_time
                ,midnight_time;


        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            fajr_time = mView.findViewById(R.id.fajr_time);
            sunrise_time = mView.findViewById(R.id.sunrise_time);
            dhuhr_time = mView.findViewById(R.id.dhuhr_time);
            asr_time = mView.findViewById(R.id.asr_time);
            sunset_time = mView.findViewById(R.id.sunset_time);
            maghrib_time = mView.findViewById(R.id.maghrib_time);
            isha_time = mView.findViewById(R.id.isha_time);
            imsak_time = mView.findViewById(R.id.imsak_time);
            midnight_time = mView.findViewById(R.id.midnight_time);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

       holder.fajr_time.setText(dataList.get(position).getTimings().getFajrTiming());
       holder.sunrise_time.setText(dataList.get(position).getTimings().getSunriseTiming());
       holder.dhuhr_time.setText(dataList.get(position).getTimings().getDhuhrTiming());
       holder.asr_time.setText(dataList.get(position).getTimings().getAsrTiming());
       holder.sunset_time.setText(dataList.get(position).getTimings().getSunsetTiming());
       holder.maghrib_time.setText(dataList.get(position).getTimings().getMaghribTiming());
       holder.isha_time.setText(dataList.get(position).getTimings().getIshaTiming());
       holder.imsak_time.setText(dataList.get(position).getTimings().getImsakTiming());
       holder.midnight_time.setText(dataList.get(position).getTimings().getMidNightTiming());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}