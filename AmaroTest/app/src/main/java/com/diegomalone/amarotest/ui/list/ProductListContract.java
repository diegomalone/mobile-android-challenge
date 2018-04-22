package com.diegomalone.amarotest.ui.list;

import com.diegomalone.amarotest.model.Product;

import java.util.List;

public interface ProductListContract {

    interface View {
        void showLoading(Boolean isVisible);
        void showError();

        void showProductList(List<Product> productList);
    }

    interface Presenter {
        void attachView(View view);
        void detachView();

        void fetchProducts();

        void productClicked(Product product);
    }
}
