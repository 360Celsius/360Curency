package com.example.dennisshar.a360curencyconvertor;

import android.os.Bundle;

import com.wang.avi.AVLoadingIndicatorView;

public class LiveActivity extends BaseActivity {

    AVLoadingIndicatorView avi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avi = new AVLoadingIndicatorView(getApplicationContext());
        avi.show();
    }


}
