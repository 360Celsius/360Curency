package com.example.dennisshar.a360curencyconvertor.fragmnets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennisshar.a360curencyconvertor.R;

public class CurrencyConvertorFragmnet extends BaseFragmnet {

    public final static String TAG = "CurrencyConvertorFragmnet";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_currency_convertor, container, false);
        return view;
    }
}
