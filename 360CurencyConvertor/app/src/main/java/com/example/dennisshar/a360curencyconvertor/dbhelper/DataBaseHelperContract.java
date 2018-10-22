package com.example.dennisshar.a360curencyconvertor.dbhelper;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.Locale;

/**
 * Created by dennisshar on 13/01/2018.
 */

public class DataBaseHelperContract {

    public static final String packageName = "com.example.dennisshar.a360curencyconvertor";
    public static final String AUTHORITY = packageName + ".provider";
    public static final String CONTENT_BASE = "content://"+AUTHORITY+"/%s";


    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DataBaseHelperContract() {
    }

    /////////////////////////////////////////////////// External IP /////////////////////////////////////////////
    public static class GeoLocation implements BaseColumns {

        public static final String URI_SUFFIX = "geo_location";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "geo_location";

        public static final String DATABASE_TABLE_GEO_LOCATION_COLUMN_CITY_COLUMN = "city";
        public static final String DATABASE_TABLE_GEO_LOCATION_COLUMN_COUNTRY_COLUMN = "country";
        public static final String DATABASE_TABLE_GEO_LOCATION_COLUMN_COUNTRY_CODE_COLUMN = "countryCode";


    }


    public static final String SQL_CREATE_ENTRIES_GEO_LOCATION =
            "CREATE TABLE " + GeoLocation.TABLE_NAME + " (" +
                    GeoLocation._ID + " INTEGER PRIMARY KEY," +
                    GeoLocation.DATABASE_TABLE_GEO_LOCATION_COLUMN_CITY_COLUMN + " TEXT," +
                    GeoLocation.DATABASE_TABLE_GEO_LOCATION_COLUMN_COUNTRY_CODE_COLUMN + " TEXT," +
                    GeoLocation.DATABASE_TABLE_GEO_LOCATION_COLUMN_COUNTRY_COLUMN + " TEXT)";

    public static final String SQL_DELETE_ENTRIES_GEO_LOCATION =
            "DROP TABLE IF EXISTS " + GeoLocation.TABLE_NAME;

    public static final String SQL_SELECT_ENTRIES_GEO_LOCATION =
            "SELECT  * FROM " + GeoLocation.TABLE_NAME + " WHERE "+ GeoLocation._ID;


    /////////////////////////////////////////////////// RATES BY COUNTRY /////////////////////////////////////////////
    public static class RatesCodeByCountryCode implements BaseColumns {

        public static final String URI_SUFFIX = "rates_code_by_country_code";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "rates_code_by_country_code";

        public static final String DATABASE_TABLE_RATES_CODE_BY_COUNTRY_CODE_CODE_COLUMN = "Code";
        public static final String DATABASE_TABLE_RATES_CODE_BY_COUNTRY_CODE_NAME_COLUMN = "Name";


    }


    public static final String SQL_CREATE_RATES_CODE_BY_COUNTRY_CODE =
            "CREATE TABLE " + RatesCodeByCountryCode.TABLE_NAME + " (" +
                    RatesCodeByCountryCode._ID + " INTEGER PRIMARY KEY," +
                    RatesCodeByCountryCode.DATABASE_TABLE_RATES_CODE_BY_COUNTRY_CODE_CODE_COLUMN + " TEXT," +
                    RatesCodeByCountryCode.DATABASE_TABLE_RATES_CODE_BY_COUNTRY_CODE_NAME_COLUMN + " TEXT)";

    public static final String SQL_DELETE_ENTRIES_RATES_CODE_BY_COUNTRY_CODE =
            "DROP TABLE IF EXISTS " + RatesCodeByCountryCode.TABLE_NAME;

    public static final String SQL_SELECT_ENTRIES_RATES_CODE_BY_COUNTRY_CODE =
            "SELECT  * FROM " + RatesCodeByCountryCode.TABLE_NAME + " WHERE "+ RatesCodeByCountryCode._ID;

}
