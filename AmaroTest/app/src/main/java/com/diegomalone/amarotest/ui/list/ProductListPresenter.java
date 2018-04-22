package com.diegomalone.amarotest.ui.list;

import android.annotation.SuppressLint;
import android.content.Intent;

import com.diegomalone.amarotest.model.Product;
import com.diegomalone.amarotest.network.ProductDataSource;
import com.diegomalone.amarotest.network.model.ProductResponse;
import com.diegomalone.amarotest.ui.detail.ProductDetailsActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

import static com.diegomalone.amarotest.ui.detail.ProductDetailsContract.PRODUCT_EXTRA;

public class ProductListPresenter implements ProductListContract.Presenter {

    private ProductListContract.View view;

    private ProductDataSource productDataSource;

    public ProductListPresenter(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
    }

    public void attachView(ProductListContract.View view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchProducts() {
        if (view != null) {
            view.showLoading(true);
        }

        productDataSource.fetchProducts()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(new Action() {
                    @Override
                    public void run() {
                        if (view != null) {
                            view.showLoading(false);
                        }
                    }
                })
                .subscribe(new Consumer<ProductResponse>() {
                    @Override
                    public void accept(ProductResponse productResponse) {
                        if (view != null) {
                            view.showProductList(productResponse.getProductList());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        if (view != null) {
                            view.showError();
                        }
                        throwable.printStackTrace();
                    }
                });
    }

    @Override
    public void productClicked(Product product) {
        if (view != null) {
            Intent intent = new Intent(view.getViewActivity(), ProductDetailsActivity.class);
            intent.putExtra(PRODUCT_EXTRA, product);

            view.getViewActivity().startActivity(intent);
        }
    }
}
