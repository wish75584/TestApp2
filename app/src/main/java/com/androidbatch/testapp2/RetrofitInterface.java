package com.androidbatch.testapp2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RetrofitInterface {

    @GET("\"status\":1,\"msg\":\"Success\",\"allrestaurants\"")
    Call<List<Model>> getImages();

}
