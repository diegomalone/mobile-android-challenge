package com.diegomalone.amarotest.ui.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.diegomalone.amarotest.BuildConfig;
import com.diegomalone.amarotest.R;
import com.diegomalone.amarotest.base.BaseActivity;
import com.diegomalone.amarotest.model.Product;
import com.diegomalone.amarotest.network.product.ProductNetworkService;
import com.diegomalone.amarotest.network.product.ProductRestClient;
import com.diegomalone.amarotest.ui.list.adapter.ProductAdapter;
import com.diegomalone.amarotest.view.RecyclerViewMargin;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListActivity extends BaseActivity implements ProductListContract.View {

    private ProductListContract.Presenter presenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);

        setupToolbar();

        createPresenter();

        configureUI();
    }

    private void createPresenter() {
        ProductRestClient restClient = serviceFactory.getService(ProductRestClient.class, BuildConfig.API_URL);

        presenter = new ProductListPresenter(new ProductNetworkService(restClient));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.attachView(this);

            presenter.fetchProducts();
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
        productAdapter = new ProductAdapter(this);

        recyclerView.setAdapter(productAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerViewMargin(((int) getResources().getDimension(R.dimen.big_margin)), 1));
    }

    @Override
    public void showLoading(Boolean isVisible) {
        // TODO
    }

    @Override
    public void showError() {
        // TODO
    }

    @Override
    public void showProductList(List<Product> productList) {
        productAdapter.setProductList(productList);
        productAdapter.notifyDataSetChanged();
    }
}
