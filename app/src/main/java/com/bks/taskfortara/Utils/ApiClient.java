package com.bks.taskfortara.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
//local
    private static final String SERVER_URL = "https://dummyjson.com/";
    //D:\xampp\htdocs\booksales


    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
       OkHttpClient httpClient = new OkHttpClient.Builder()
               .protocols(Util.immutableList(Protocol.HTTP_1_1))
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(SERVER_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
