package com.diegomalone.amarotest.network.model;

import com.diegomalone.amarotest.model.Product;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResponse {

    @SerializedName("products")
    private List<Product> productList;

    public ProductResponse(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "productList=" + productList +
                '}';
    }
}
