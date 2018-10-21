package com.example.dennisshar.a360curencyconvertor;

import android.content.Intent;
import android.os.Bundle;

import com.example.dennisshar.a360curencyconvertor.service.DataPullService;
import com.example.dennisshar.a360curencyconvertor.service.DataPullServiceConsts;
import com.wang.avi.AVLoadingIndicatorView;

public class LiveActivity extends BaseActivity {

    AVLoadingIndicatorView avi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avi = new AVLoadingIndicatorView(getApplicationContext());
        avi.show();


        Intent msgIntent = new Intent(getApplicationContext(), DataPullService.class);
        msgIntent.putExtra(DataPullServiceConsts.DATA_TYPE_KEY, DataPullServiceConsts.GET_CURRENCY_BY_COUNTRY_CODE);
        startService(msgIntent);
    }


}
