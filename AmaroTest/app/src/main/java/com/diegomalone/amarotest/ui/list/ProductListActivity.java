package com.diegomalone.amarotest.ui.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.diegomalone.amarotest.BuildConfig;
import com.diegomalone.amarotest.R;
import com.diegomalone.amarotest.base.BaseActivity;
import com.diegomalone.amarotest.model.Product;
import com.diegomalone.amarotest.network.product.ProductNetworkService;
import com.diegomalone.amarotest.network.product.ProductRestClient;
import com.diegomalone.amarotest.ui.list.adapter.ProductAdapter;
import com.diegomalone.amarotest.view.SpacingItemDecorator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.diegomalone.amarotest.ui.list.ProductListContract.PRODUCT_LIST_SPAN_COUNT;

public class ProductListActivity extends BaseActivity implements ProductListContract.View {

    private ProductListContract.Presenter presenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.recyclerViewSwipeToRefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;

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
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.fetchProducts();
            }
        });

        productAdapter = new ProductAdapter(this);

        recyclerView.setAdapter(productAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(PRODUCT_LIST_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new SpacingItemDecorator(((int) getResources().getDimension(R.dimen.small_margin))));
    }

    @Override
    public void showLoading(Boolean isVisible) {
        swipeRefreshLayout.setRefreshing(isVisible);
    }

    @Override
    public void showError() {
        Snackbar.make(constraintLayout, getString(R.string.unknown_error), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showProductList(List<Product> productList) {
        productAdapter.setProductList(productList);
        productAdapter.notifyDataSetChanged();
    }
}
