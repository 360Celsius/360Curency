package com.example.dennisshar.a360curencyconvertor.dbhelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by dennisshar on 20/01/2018.
 */

public class CurrencyConvertorProvider extends ContentProvider {

    public static DatabaseHelper helper = null;

    private static final int GEO_LOCATION = 1;
    private static final int ATES_CODE_BY_COUNTRY_CODE = 2;

    private static final UriMatcher mMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        mMatcher.addURI(DataBaseHelperContract.AUTHORITY, DataBaseHelperContract.GeoLocation.URI_SUFFIX, GEO_LOCATION);
        mMatcher.addURI(DataBaseHelperContract.AUTHORITY, DataBaseHelperContract.RatesCodeByCountryCode.URI_SUFFIX, ATES_CODE_BY_COUNTRY_CODE);
    }

    @Override
    public boolean onCreate() {
        helper  = DatabaseHelper.getInstance(getContext());

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String nullColumnHack = null;
        long id = db.insert(getTableName(uri), nullColumnHack, contentValues);

        if(id > -1){
            Uri insertedId = ContentUris.withAppendedId(getContentUriName(uri), id);
            getContext().getContentResolver().notifyChange(insertedId, null);
            return insertedId;
        }
        else
            return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    public static String getTableName(Uri uri) {
        String tableName = null;

        switch (mMatcher.match(uri)) {
            case GEO_LOCATION:
                tableName = DataBaseHelperContract.GeoLocation.TABLE_NAME;
                break;

            case ATES_CODE_BY_COUNTRY_CODE:
                tableName = DataBaseHelperContract.RatesCodeByCountryCode.TABLE_NAME;
                break;

        }

        return tableName;
    }

    public Uri getContentUriName(Uri uri) {
        Uri contentUriName = null;

        switch (mMatcher.match(uri)) {
            case GEO_LOCATION:
                contentUriName = DataBaseHelperContract.GeoLocation.CONTENT_URI;
                break;

            case ATES_CODE_BY_COUNTRY_CODE:
                contentUriName = DataBaseHelperContract.RatesCodeByCountryCode.CONTENT_URI;
                break;

        }

        return contentUriName;
    }
}
