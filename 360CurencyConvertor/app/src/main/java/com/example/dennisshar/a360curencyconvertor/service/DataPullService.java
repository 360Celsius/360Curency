package com.example.dennisshar.a360curencyconvertor.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.dennisshar.a360curencyconvertor.datamodels.GeoLocationDataModel;
import com.example.dennisshar.a360curencyconvertor.jsonparser.JsonParser;
import com.example.dennisshar.a360curencyconvertor.network.NetworkHTTPConnection;
import com.example.dennisshar.a360curencyconvertor.network.NetworkHttpAPIurlConst;

public class DataPullService extends IntentService {

    public static final String GET_QOUTES_DATA = "GET_DATA";
    private static NetworkHttpAPIurlConst networkHttpAPIurlConst;
    private static NetworkHTTPConnection networkHTTPConnection;
    private static JsonParser jSONparser;


    @Override
    public void onCreate() {
        super.onCreate();
        networkHTTPConnection = NetworkHTTPConnection.getInstance();
        networkHttpAPIurlConst = NetworkHttpAPIurlConst.getInstance();
        jSONparser =  JsonParser.getInstance();

    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DataPullService(String name) {
        super(name);
    }

    public DataPullService() {
        super("DataPullService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent.getStringExtra(DataPullServiceConsts.DATA_TYPE_KEY).equalsIgnoreCase(DataPullServiceConsts.GET_GEO_LOCATION_BY_IP)) {
            GeoLocationDataModel geoLocationDataModel = jSONparser.getParesedGeoLocationDataModel( networkHTTPConnection.getHttp(networkHttpAPIurlConst.getLocationByIpUrl()) );

            
        }

    }
}
