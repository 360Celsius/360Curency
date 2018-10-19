package com.example.dennisshar.a360curencyconvertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wang.avi.AVLoadingIndicatorView;

public class SplashActivity extends BaseActivity {

    AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        avi = new AVLoadingIndicatorView(getApplicationContext());
        avi.show();
    }
}
