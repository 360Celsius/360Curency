package com.example.dennisshar.a360curencyconvertor.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.dennisshar.a360curencyconvertor.BaseActivity;
import com.example.dennisshar.a360curencyconvertor.datamodels.CurenncyByCountryCode;
import com.example.dennisshar.a360curencyconvertor.datamodels.GeoLocationDataModel;
import com.example.dennisshar.a360curencyconvertor.dbhelper.DatabaseHelper;
import com.example.dennisshar.a360curencyconvertor.jsonparser.JsonParser;
import com.example.dennisshar.a360curencyconvertor.network.NetworkHTTPConnection;
import com.example.dennisshar.a360curencyconvertor.network.NetworkHttpAPIurlConst;

import java.util.ArrayList;

public class DataPullService extends IntentService {

    public static final String GET_DATA = "GET_DATA";
    private static NetworkHttpAPIurlConst networkHttpAPIurlConst = null;
    private static NetworkHTTPConnection networkHTTPConnection = null;
    private static JsonParser jSONparser = null;
    private static DatabaseHelper helper = null;


    @Override
    public void onCreate() {
        super.onCreate();
        networkHTTPConnection = NetworkHTTPConnection.getInstance();
        networkHttpAPIurlConst = NetworkHttpAPIurlConst.getInstance();
        jSONparser =  JsonParser.getInstance();
        helper = BaseActivity.helper;

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
            GeoLocationDataModel geoLocationDataModel = jSONparser.getParesedGeoLocationDataModel(networkHTTPConnection.getHttp(networkHttpAPIurlConst.getLocationByIpUrl()));
            helper.bulkGeoLocationdata(geoLocationDataModel);

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_DATA);
            broadcastIntent.putExtra(DataPullServiceConsts.DATA_TYPE_KEY, DataPullServiceConsts.GET_GEO_LOCATION_BY_IP);
            sendBroadcast(broadcastIntent);

        } else if (intent.getStringExtra(DataPullServiceConsts.DATA_TYPE_KEY).equalsIgnoreCase(DataPullServiceConsts.GET_CURRENCY_BY_COUNTRY_CODE)) {

            ArrayList<CurenncyByCountryCode> curenncyByCountryCodeArray = jSONparser.getParesedGCurenncyByCountryCode( networkHTTPConnection.getHttp(networkHttpAPIurlConst.getCurrenciesByCountryCodeUrl()) );
            helper.bulkInsertCurrencyCodeByCountryCode(curenncyByCountryCodeArray);

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_DATA);
            broadcastIntent.putExtra(DataPullServiceConsts.DATA_TYPE_KEY, DataPullServiceConsts.GET_CURRENCY_BY_COUNTRY_CODE);
            sendBroadcast(broadcastIntent);
        }
    }
}
