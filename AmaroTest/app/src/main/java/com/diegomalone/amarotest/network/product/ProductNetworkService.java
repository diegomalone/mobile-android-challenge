package com.diegomalone.amarotest.network.product;

import com.diegomalone.amarotest.network.ProductDataSource;
import com.diegomalone.amarotest.network.model.ProductResponse;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ProductNetworkService implements ProductDataSource {

    private ProductRestClient api;

    public ProductNetworkService(ProductRestClient api) {
        this.api = api;
    }

    @Override
    public Observable<ProductResponse> fetchProducts() {
        return api.fetchProducts()
                .subscribeOn(Schedulers.io());
    }
}
