package com.diegomalone.amarotest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.diegomalone.amarotest.R;
import com.diegomalone.amarotest.network.ServiceFactory;

import butterknife.BindView;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    protected ServiceFactory serviceFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        serviceFactory = ServiceFactory.getInstance(this);
    }

    protected void setupToolbar(Boolean displayHomeAsUpEnabled) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(displayHomeAsUpEnabled);
            getSupportActionBar().setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
