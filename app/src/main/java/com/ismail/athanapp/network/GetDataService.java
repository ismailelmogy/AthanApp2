package com.ismail.athanapp.network;

import com.ismail.athanapp.model.BasicResponse;
import com.ismail.athanapp.model.Data;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService{

        @GET("/v1/calendar?latitude=51.508515&longitude=-0.1254872&method=2&month=4&year=2017")
        Call<BasicResponse> getAllData();
}
