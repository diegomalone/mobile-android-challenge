package com.diegomalone.amarotest.ui.list.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.diegomalone.amarotest.model.Product;
import com.diegomalone.amarotest.view.ProductCardView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private View.OnClickListener onClickListener;

    private List<Product> productList = new ArrayList<>();

    public ProductAdapter(Context context, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.onClickListener = onClickListener;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ProductCardView productCardView = new ProductCardView(mContext);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        productCardView.setLayoutParams(layoutParams);

        return new ProductViewHolder(productCardView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder productViewHolder, int i) {
        ((ProductCardView) productViewHolder.itemView).setProduct(productList.get(i));
        productViewHolder.itemView.setOnClickListener(onClickListener);
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public ProductViewHolder(View v) {
            super(v);
        }
    }
}

