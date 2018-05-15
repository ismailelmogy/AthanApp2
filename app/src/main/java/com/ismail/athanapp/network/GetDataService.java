package com.ismail.athanapp.network;

import com.ismail.athanapp.model.BasicResponse;
import com.ismail.athanapp.model.Data;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService{

//        @GET("/v1/calendar?latitude=51.508515&longitude=-0.1254872&method=2&month=4&year=2017")

//        Call<BasicResponse> getAllData(@Query("city") String city,
//                                       @Query("country") String country);

        @GET("/v1/calendar")
        Call<BasicResponse> getAllData(@Query("latitude") double latitude,
                                       @Query("longitude") double longitude);
}
