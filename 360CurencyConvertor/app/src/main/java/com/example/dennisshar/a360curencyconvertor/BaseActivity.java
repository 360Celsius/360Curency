package com.example.dennisshar.a360curencyconvertor;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.dennisshar.a360curencyconvertor.dbhelper.DatabaseHelper;
import com.example.dennisshar.a360curencyconvertor.recivers.ResponseReceiver;
import com.example.dennisshar.a360curencyconvertor.service.DataPullService;
import com.example.dennisshar.a360curencyconvertor.service.DataPullServiceConsts;

public class BaseActivity extends AppCompatActivity {

    public static DatabaseHelper helper = null;
    private static ResponseReceiver receiver = null;
    private static IntentFilter filter = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.statusBarColor));
        }

        helper = DatabaseHelper.getInstance(getApplicationContext());

    }

    @Override
    protected void onResume() {
        super.onResume();
        filter = new IntentFilter(DataPullService.GET_DATA);
        receiver = new ResponseReceiver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
