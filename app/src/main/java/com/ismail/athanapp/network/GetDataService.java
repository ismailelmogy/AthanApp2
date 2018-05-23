package com.ismail.athanapp.network;

import com.ismail.athanapp.model.BasicResponse;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService{

//        @GET("/v1/calendar?latitude=51.508515&longitude=-0.1254872&method=2&month=4&year=2017")

//        Call<BasicResponse> getAllData(@Query("city") String city,
//                                       @Query("country") String country);

        @GET("/v1/calendar")
        Observable<BasicResponse> getAllData(@Query("latitude") double latitude,
                              @Query("longitude") double longitude);

//        Call<BasicResponse> getAllData(@Query("latitude") double latitude,
//                                       @Query("longitude") double longitude);

}
