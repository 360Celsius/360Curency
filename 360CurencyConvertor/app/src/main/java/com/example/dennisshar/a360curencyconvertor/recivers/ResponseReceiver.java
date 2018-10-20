package com.example.dennisshar.a360curencyconvertor.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.dennisshar.a360curencyconvertor.LiveActivity;
import com.example.dennisshar.a360curencyconvertor.service.DataPullServiceConsts;




public class ResponseReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        try{
            switch (intent.getStringExtra(DataPullServiceConsts.DATA_TYPE_KEY)) {
                case DataPullServiceConsts.GET_GEO_LOCATION_BY_IP:
                    Intent intentone = new Intent(context.getApplicationContext(), LiveActivity.class);
                    intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentone);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
            //TODO load error screen
        }
    }

}
