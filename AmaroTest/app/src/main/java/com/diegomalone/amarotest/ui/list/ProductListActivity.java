package com.diegomalone.amarotest.ui.list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.diegomalone.amarotest.R;

public class ProductListActivity extends Activity implements ProductListContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
    }
}
