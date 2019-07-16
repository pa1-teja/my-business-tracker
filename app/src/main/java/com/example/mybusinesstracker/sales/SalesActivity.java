package com.example.mybusinesstracker.sales;

import android.os.Bundle;

import com.example.mybusinesstracker.BaseCalsses.BaseActivity;
import com.example.mybusinesstracker.R;
import com.example.mybusinesstracker.sales.ui.sales.SalesFragment;

public class SalesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sales_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SalesFragment.newInstance())
                    .commitNow();
        }
    }
}
