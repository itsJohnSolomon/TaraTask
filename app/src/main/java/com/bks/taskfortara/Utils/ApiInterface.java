package com.bks.taskfortara.Utils;

import com.bks.taskfortara.Model.ProductAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("products")
    Call<ProductAll> getProducts();

}
