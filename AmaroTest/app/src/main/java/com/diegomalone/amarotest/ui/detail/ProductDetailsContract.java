package com.diegomalone.amarotest.ui.detail;

import com.diegomalone.amarotest.model.Product;

public interface ProductDetailsContract {

    String PRODUCT_EXTRA = "product";

    interface View {
        void showProduct(Product product);
    }

    interface Presenter {
        void attachView(ProductDetailsContract.View view);

        void detachView();

        void setupIntentParameters(Product product);
    }
}
