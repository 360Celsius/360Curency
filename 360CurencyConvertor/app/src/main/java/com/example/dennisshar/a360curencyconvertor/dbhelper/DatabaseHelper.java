package com.example.dennisshar.a360curencyconvertor.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dennisshar.a360curencyconvertor.datamodels.GeoLocationDataModel;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CurrencyConvertor.db";
    private static DatabaseHelper sInstance;
    private Context context;

    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_GEO_LOCATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_GEO_LOCATION);
        }
    }

    //======================================================   GEO LOCATION data   ===========================================================

    public void bulkGeoLocationdata(GeoLocationDataModel geoLocationDataModel){
        deleteExternalIPdataTable();
        ContentValues[] ipInfoObjectArr = new ContentValues[1];;
        for(int i=0;i<ipInfoObjectArr.length;i++) {
            ContentValues values = new ContentValues();
            values.put(DataBaseHelperContract.GeoLocation.DATABASE_TABLE_GEO_LOCATION_COLUMN_CITY, geoLocationDataModel.getCity());
            values.put(DataBaseHelperContract.GeoLocation.DATABASE_TABLE_GEO_LOCATION_COLUMN_COUNTRY, geoLocationDataModel.getCountry());
            values.put(DataBaseHelperContract.GeoLocation.DATABASE_TABLE_GEO_LOCATION_COLUMN_COUNTRY_CODE, geoLocationDataModel.getCountryCode());
            ipInfoObjectArr[i] = values;
        }
        context.getContentResolver().bulkInsert(DataBaseHelperContract.GeoLocation.CONTENT_URI, ipInfoObjectArr);
    }

    private void deleteExternalIPdataTable(){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DataBaseHelperContract.SQL_DELETE_ENTRIES_GEO_LOCATION, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public GeoLocationDataModel getGeoLocationdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DataBaseHelperContract.SQL_SELECT_ENTRIES_GEO_LOCATION, null);

        GeoLocationDataModel geoLocationDataModel = new GeoLocationDataModel();
        try {
            if (cursor.moveToFirst()) {
                cursor.getString(cursor.getColumnIndex(DataBaseHelperContract.GeoLocation.DATABASE_TABLE_GEO_LOCATION_NAME_KEY));
            }
        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return geoLocationDataModel;
    }
}
