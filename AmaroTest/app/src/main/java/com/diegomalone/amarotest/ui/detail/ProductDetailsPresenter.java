package com.diegomalone.amarotest.ui.detail;

import com.diegomalone.amarotest.model.Product;

public class ProductDetailsPresenter implements ProductDetailsContract.Presenter {

    private ProductDetailsContract.View view;

    private Product product;

    public void attachView(ProductDetailsContract.View view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    @Override
    public void setupIntentParameters(Product product) {
        this.product = product;

        if (view != null) {
            view.showProduct(product);
        }
    }

}
