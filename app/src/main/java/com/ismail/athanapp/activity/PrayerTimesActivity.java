package com.ismail.athanapp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ismail.athanapp.R;
import com.ismail.athanapp.adapter.CustomAdapter;
import com.ismail.athanapp.model.BasicResponse;
import com.ismail.athanapp.model.Timing;
import com.ismail.athanapp.network.GetDataService;
import com.ismail.athanapp.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrayerTimesActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    double lattitude = 0.00, longitude = 0.00;
    TextView fajr_time ,sunrise_time ,dhuhr_time ,sunset_time,maghrib_time,
            isha_time,imsak_time,midnight_time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_times);
//        fajr_time = findViewById(R.id.fajr_time);
//        sunrise_time = findViewById(R.id.sunrise_time);
//        dhuhr_time = findViewById(R.id.dhuhr_time);
//        sunset_time = findViewById(R.id.sunset_time);
//        maghrib_time = findViewById(R.id.maghrib_time);
//        isha_time =findViewById(R.id.isha_time);
//        imsak_time = findViewById(R.id.imsak_time);
//        midnight_time = findViewById(R.id.midnight_time);

        recyclerView = findViewById(R.id.customRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PrayerTimesActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        progressDoalog = new ProgressDialog(PrayerTimesActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            lattitude = extras.getDouble("lattitude", 0.000);
            longitude = extras.getDouble("longitude", 0.00);
        }
//        String countryName = intent.getStringExtra("country_name");
        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class);

        Observable<BasicResponse> observable = service.getAllData(lattitude, longitude);

        observable.subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<BasicResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BasicResponse response) {

                        progressDoalog.dismiss();
                        Toast.makeText(PrayerTimesActivity.this, "Success", Toast.LENGTH_LONG).show();
                        generateDataList(response);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError:", e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("onCompleted:", "called");
                        Toast.makeText(PrayerTimesActivity.this, "completed", Toast.LENGTH_SHORT).show();

                    }
                });

//        Call<BasicResponse> call = service.getAllData(cityName,countryName);
//        Call<BasicResponse> call = service.getAllData(lattitude,longitude);
//        call.enqueue(new Callback<BasicResponse>() {
//            @Override
//            public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
//                progressDoalog.dismiss();
//                Toast.makeText(PrayerTimesActivity.this, "Success", Toast.LENGTH_LONG).show();
//                generateDataList(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<BasicResponse> call, Throwable t) {
//                progressDoalog.dismiss();
//                Toast.makeText(PrayerTimesActivity.this, "Something went wrong...Please try later!",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(BasicResponse response) {
        adapter = new CustomAdapter(this, response.getData());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PrayerTimesActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
