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

        public static final String DATABASE_TABLE_GEO_LOCATION_NAME_KEY = "geo_location";

        public static final String DATABASE_TABLE_GEO_LOCATION_COLUMN_CITY = "city";
        public static final String DATABASE_TABLE_GEO_LOCATION_COLUMN_COUNTRY = "country";



    }


    public static final String SQL_CREATE_ENTRIES_GEO_LOCATION =
            "CREATE TABLE " + GeoLocation.DATABASE_TABLE_GEO_LOCATION_NAME_KEY + " (" +
                    GeoLocation._ID + " INTEGER PRIMARY KEY," +
                    GeoLocation.DATABASE_TABLE_GEO_LOCATION_COLUMN_CITY + " TEXT," +
                    GeoLocation.DATABASE_TABLE_GEO_LOCATION_COLUMN_COUNTRY + " TEXT)";

    public static final String SQL_DELETE_ENTRIES_GEO_LOCATION =
            "DROP TABLE IF EXISTS " + GeoLocation.DATABASE_TABLE_GEO_LOCATION_NAME_KEY;

    public static final String SQL_SELECT_ENTRIES_GEO_LOCATION =
            "SELECT  * FROM " + GeoLocation.DATABASE_TABLE_GEO_LOCATION_NAME_KEY + " WHERE "+ GeoLocation._ID;

}
