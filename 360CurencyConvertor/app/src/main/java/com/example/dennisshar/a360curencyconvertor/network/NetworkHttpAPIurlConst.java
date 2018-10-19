package com.example.dennisshar.a360curencyconvertor.network;

public class NetworkHttpAPIurlConst {

    private static String GET_LOCATION_BY_IP_URL = "http://ip-api.com/json";

    private static NetworkHttpAPIurlConst _instance;


    private NetworkHttpAPIurlConst()
    {

    }

    public static NetworkHttpAPIurlConst getInstance()
    {
        if (_instance == null)
        {
            _instance = new NetworkHttpAPIurlConst();
        }
        return _instance;
    }

    public String getLocationByIpUrl(){
        return GET_LOCATION_BY_IP_URL;
    }
}
