package com.bks.taskfortara.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bks.taskfortara.Model.products;
import com.bks.taskfortara.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends  RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context c;
    private List<products> productList;
    TextView nos;
    public ProductAdapter(Context c, List<products> productList) {
        this.c = c;
        this.productList = productList;

    }
    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(c);
        view = inflater.inflate(R.layout.item_quote_layout, parent, false);
        final ProductAdapter.ProductViewHolder viewHolder = new ProductAdapter.ProductViewHolder(view);
//
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        products product = productList.get(position);
        holder.name.setText(product.getTitle());
        holder.cat.setText(product.getBrand());
        holder.rate.setText(String.valueOf(product.getPrice()));
        holder.rating.setText(String.valueOf(product.getRating()));
        holder.stock.setText(String.valueOf(product.getStock()));
        holder.desc.setText(String.valueOf(product.getDescription()));
        Glide.with(c.getApplicationContext()).load(product.getThumbnail())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    class ProductViewHolder extends RecyclerView.ViewHolder {


        TextView name,cat,rate,rating,stock,desc;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.rating);
            stock = itemView.findViewById(R.id.stock);
            cat = itemView.findViewById(R.id.cat);
            rate = itemView.findViewById(R.id.rate);
            imageView = itemView.findViewById(R.id.imageView);
            desc = itemView.findViewById(R.id.desc);


        }
    }
}
