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
            geoLocationDataModel.setAs ( reader.has(jsonParserKeys.AS)&&!reader.isNull(jsonParserKeys.AS) ?  reader.getString(jsonParserKeys.AS):""   );
            geoLocationDataModel.setCity ( reader.has(jsonParserKeys.CITY)&&!reader.isNull(jsonParserKeys.CITY) ?  reader.getString(jsonParserKeys.CITY):""   );
            geoLocationDataModel.setCountry ( reader.has(jsonParserKeys.COUNTRY)&&!reader.isNull(jsonParserKeys.COUNTRY) ?  reader.getString(jsonParserKeys.COUNTRY):""   );
            geoLocationDataModel.setCountryCode ( reader.has(jsonParserKeys.COUNTRY_CODE)&&!reader.isNull(jsonParserKeys.COUNTRY_CODE) ?  reader.getString(jsonParserKeys.COUNTRY_CODE):""   );
            geoLocationDataModel.setIsp ( reader.has(jsonParserKeys.ISP)&&!reader.isNull(jsonParserKeys.ISP) ?  reader.getString(jsonParserKeys.ISP):""   );
            geoLocationDataModel.setLat ( reader.has(jsonParserKeys.LAT)&&!reader.isNull(jsonParserKeys.LAT) ?  reader.getString(jsonParserKeys.LAT):""   );
            geoLocationDataModel.setLon ( reader.has(jsonParserKeys.LON)&&!reader.isNull(jsonParserKeys.LON) ?  reader.getString(jsonParserKeys.LON):""   );
            geoLocationDataModel.setOrg ( reader.has(jsonParserKeys.ORG)&&!reader.isNull(jsonParserKeys.ORG) ?  reader.getString(jsonParserKeys.ORG):""   );
            geoLocationDataModel.setQuery ( reader.has(jsonParserKeys.QUERY)&&!reader.isNull(jsonParserKeys.QUERY) ?  reader.getString(jsonParserKeys.QUERY):""   );
            geoLocationDataModel.setRegion ( reader.has(jsonParserKeys.REGION)&&!reader.isNull(jsonParserKeys.REGION) ?  reader.getString(jsonParserKeys.REGION):""   );
            geoLocationDataModel.setRegionName ( reader.has(jsonParserKeys.REGION_NAME)&&!reader.isNull(jsonParserKeys.REGION_NAME) ?  reader.getString(jsonParserKeys.REGION_NAME):""   );
            geoLocationDataModel.setStatus ( reader.has(jsonParserKeys.STATUS)&&!reader.isNull(jsonParserKeys.STATUS) ?  reader.getString(jsonParserKeys.STATUS):""   );
            geoLocationDataModel.setTimezone ( reader.has(jsonParserKeys.TIME_ZONE)&&!reader.isNull(jsonParserKeys.TIME_ZONE) ?  reader.getString(jsonParserKeys.TIME_ZONE):""   );
            geoLocationDataModel.setZip ( reader.has(jsonParserKeys.ZIP)&&!reader.isNull(jsonParserKeys.ZIP) ?  reader.getString(jsonParserKeys.ZIP):""   );



        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return geoLocationDataModel;

    }


}
