package com.example.latestnewsjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {

@GET("Latest")
    Call<List<ModelClass>> getData(@Header("X-RapidAPI-Key") String XRapidAPIKey);

    @GET("Business")
    Call<List<ModelClass>> getDataBusiness(@Header("X-RapidAPI-Key") String XRapidAPIKey);

    @GET("Sport")
    Call<List<ModelClass>> getDataSport(@Header("X-RapidAPI-Key") String XRapidAPIKey);

    @GET("Technology")
    Call<List<ModelClass>> getDataTechnology(@Header("X-RapidAPI-Key") String XRapidAPIKey);

}
