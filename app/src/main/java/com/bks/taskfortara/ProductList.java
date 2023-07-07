package com.bks.taskfortara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bks.taskfortara.Adapter.ProductAdapter;
import com.bks.taskfortara.Model.ProductAll;
import com.bks.taskfortara.Utils.ApiClient;
import com.bks.taskfortara.Utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductList extends AppCompatActivity {
  RecyclerView productList;
  ConstraintLayout constraint_progress_bar;
  ProductAll ListProduct;
  ProductAdapter mAdapter;
  ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        productList=findViewById(R.id.productList);
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        constraint_progress_bar=findViewById(R.id.constraint_progress_bar);
        Load();
    }

    private void Load() {
        constraint_progress_bar.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ProductAll> call = apiInterface.getProducts();
        call.enqueue(new Callback<ProductAll>() {
            @Override
            public void onResponse(Call<ProductAll> call, Response<ProductAll> response) {
                constraint_progress_bar.setVisibility(View.GONE);
                ListProduct = response.body();
                ViewDetails();

            }

            @Override
            public void onFailure(Call<ProductAll> call, Throwable t) {
                Log.e("Error1 : ", t.toString());
                constraint_progress_bar.setVisibility(View.GONE);

            }
        });
    }

    private void ViewDetails() {
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProductList.this);
        productList.setLayoutManager(layoutManager);
        mAdapter = new ProductAdapter(ProductList.this, ListProduct.getProducts());
        productList.setAdapter(mAdapter);
    }


}