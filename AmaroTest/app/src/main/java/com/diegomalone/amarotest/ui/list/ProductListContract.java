package com.diegomalone.amarotest.ui.list;

import com.diegomalone.amarotest.model.Product;

import java.util.List;

public interface ProductListContract {

    int PRODUCT_LIST_SPAN_COUNT = 2;

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
