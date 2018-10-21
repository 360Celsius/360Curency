package com.example.dennisshar.a360curencyconvertor.jsonparser;

import com.example.dennisshar.a360curencyconvertor.datamodels.GeoLocationDataModel;
import com.example.dennisshar.a360curencyconvertor.network.NetworkHttpAPIurlConst;

import org.json.JSONArray;
import org.json.JSONObject;


public class JsonParser {

    private static JsonParserKeys jsonParserKeys = null;
    private static JsonParser _instance = null;


    private JsonParser()
    {
        jsonParserKeys = new JsonParserKeys();
    }

    public static JsonParser getInstance()
    {
        if (_instance == null)
        {
            _instance = new JsonParser();
        }
        return _instance;
    }



    public GeoLocationDataModel getParesedGeoLocationDataModel(String apiGeoLocationJsaonStringResponce){

        GeoLocationDataModel geoLocationDataModel = null;
        JSONObject reader = null;

        try {
            geoLocationDataModel = new GeoLocationDataModel();
            reader = new JSONObject(apiGeoLocationJsaonStringResponce);
            geoLocationDataModel.setCity ( reader.has(jsonParserKeys.CITY)&&!reader.isNull(jsonParserKeys.CITY) ?  reader.getString(jsonParserKeys.CITY):""   );
            geoLocationDataModel.setCountry ( reader.has(jsonParserKeys.COUNTRY)&&!reader.isNull(jsonParserKeys.COUNTRY) ?  reader.getString(jsonParserKeys.COUNTRY):""   );
            geoLocationDataModel.setCountryCode ( reader.has(jsonParserKeys.COUNTRY_CODE)&&!reader.isNull(jsonParserKeys.COUNTRY_CODE) ?  reader.getString(jsonParserKeys.COUNTRY_CODE):""   );

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return geoLocationDataModel;

    }


}
