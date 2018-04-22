package com.diegomalone.amarotest.network.product;

import com.diegomalone.amarotest.network.model.ProductResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ProductRestClient {

    @GET("59b6a65a0f0000e90471257d")
    Observable<ProductResponse> fetchProducts();
}
