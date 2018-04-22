package com.diegomalone.amarotest.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;

import com.diegomalone.amarotest.R;
import com.diegomalone.amarotest.base.BaseActivity;
import com.diegomalone.amarotest.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.diegomalone.amarotest.ui.detail.ProductDetailsContract.PRODUCT_EXTRA;

public class ProductDetailsActivity extends BaseActivity implements ProductDetailsContract.View {

    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;

    private ProductDetailsContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);

        setupToolbar(true);

        createPresenter();
        processIntentParameters();

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
        // TODO
    }
}
