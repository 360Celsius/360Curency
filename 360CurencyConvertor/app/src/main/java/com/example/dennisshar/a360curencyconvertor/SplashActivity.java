package com.example.dennisshar.a360curencyconvertor;

import android.content.Intent;
import android.os.Bundle;

import com.example.dennisshar.a360curencyconvertor.service.DataPullService;
import com.example.dennisshar.a360curencyconvertor.service.DataPullServiceConsts;
import com.wang.avi.AVLoadingIndicatorView;

public class SplashActivity extends BaseActivity {

    AVLoadingIndicatorView splashActivityLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashActivityLoadingView = (AVLoadingIndicatorView) findViewById(R.id.splash_activity_avi);
        splashActivityLoadingView.show();

        Intent msgIntent = new Intent(getApplicationContext(), DataPullService.class);
        msgIntent.putExtra(DataPullServiceConsts.DATA_TYPE_KEY, DataPullServiceConsts.GET_GEO_LOCATION_BY_IP);
        startService(msgIntent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashActivityLoadingView.hide();
    }
}
