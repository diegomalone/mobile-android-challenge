package com.diegomalone.amarotest.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diegomalone.amarotest.R;
import com.diegomalone.amarotest.base.BaseActivity;
import com.diegomalone.amarotest.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.diegomalone.amarotest.ui.detail.ProductDetailsContract.PRODUCT_EXTRA;

public class ProductDetailsActivity extends BaseActivity implements ProductDetailsContract.View {

    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;

    @BindView(R.id.productName)
    TextView productName;

    @BindView(R.id.productImage)
    ImageView productImage;

    @BindView(R.id.productPrice)
    TextView productPrice;

    @BindView(R.id.productInstallments)
    TextView productInstallments;

    private ProductDetailsContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);

        setupToolbar(true);

        createPresenter();

        configureUI();
    }

    private void createPresenter() {
        presenter = new ProductDetailsPresenter();
    }

    private void processIntentParameters() {
        Intent intent = getIntent();

        Product product = intent.getParcelableExtra(PRODUCT_EXTRA);

        if (presenter != null) {
            presenter.setupIntentParameters(product);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.attachView(this);
        }

        processIntentParameters();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    private void configureUI() {
        // TODO
    }

    @Override
    public void showProduct(Product product) {
        productName.setText(product.getName());
        productPrice.setText(product.getActualPrice());
        productInstallments.setText(product.getInstallments());

        Glide.with(this)
                .load(product.getImageUrl())
                .into(productImage);
    }
}
