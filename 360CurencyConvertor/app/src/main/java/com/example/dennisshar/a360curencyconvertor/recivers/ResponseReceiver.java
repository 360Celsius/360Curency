package com.example.dennisshar.a360curencyconvertor.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.dennisshar.a360curencyconvertor.LiveActivity;
import com.example.dennisshar.a360curencyconvertor.R;
import com.example.dennisshar.a360curencyconvertor.fragmnets.CurrencyConvertorFragmnet;
import com.example.dennisshar.a360curencyconvertor.service.DataPullServiceConsts;




public class ResponseReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        try{
            FragmentTransaction ft =   ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();

            if(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_view_placeholder) != null) {
                ft.remove(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_view_placeholder));
            }


            switch (intent.getStringExtra(DataPullServiceConsts.DATA_TYPE_KEY)) {
                case DataPullServiceConsts.GET_GEO_LOCATION_BY_IP:
                    Intent intentone = new Intent(context.getApplicationContext(), LiveActivity.class);
                    intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentone);
                    break;

                case DataPullServiceConsts.GET_CURRENCY_BY_COUNTRY_CODE:
                    try {
                        ft.add(R.id.fragment_view_placeholder, new CurrencyConvertorFragmnet(), CurrencyConvertorFragmnet.TAG);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
            }

            ft.commit();

        }catch (Exception e){
            e.printStackTrace();
            //TODO load error screen
        }
    }

}
