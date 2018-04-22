package com.diegomalone.amarotest.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diegomalone.amarotest.R;
import com.diegomalone.amarotest.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductCardView extends CardView {

    @BindView(R.id.productName)
    TextView productName;

    @BindView(R.id.productImage)
    ImageView productImage;

    @BindView(R.id.productPrice)
    TextView productPrice;

    @BindView(R.id.productInstallments)
    TextView productInstallments;

    private Product product;

    public ProductCardView(Context context) {
        super(context);
        initialize(context);
    }

    public ProductCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context) {
        View view = inflate(context, R.layout.view_product_card, this);
        ButterKnife.bind(this, view);
    }

    public void setProduct(Product product) {
        this.product = product;

        productName.setText(product.getName());
        productPrice.setText(product.getActualPrice());
        productInstallments.setText(product.getInstallments());

        Glide.with(getContext())
                .load(product.getImageUrl())
                .into(productImage);
    }

    public Product getProduct() {
        return product;
    }
}
