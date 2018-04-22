package com.diegomalone.amarotest.network;

import com.diegomalone.amarotest.network.model.ProductResponse;

import io.reactivex.Observable;

public interface ProductDataSource {

    Observable<ProductResponse> fetchProducts();
}
