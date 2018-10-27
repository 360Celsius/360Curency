package com.example.dennisshar.a360curencyconvertor.fragmnets;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dennisshar.a360curencyconvertor.R;

public class CurrencyConvertorFragmnet extends BaseFragmnet implements View.OnClickListener {

    public final static String TAG = "CurrencyConvertorFragmnet";

    private View dotButton;
    private TextView dotButtonText;

    private View zeroButton;
    private TextView zeroButtonText;

    private View backButton;
    private ImageView backButtonImg;


    private View oneButton;
    private TextView oneButtonText;

    private View twoButton;
    private TextView twoButtonText;

    private View threeButton;
    private TextView threeButtonText;

    private View fourButton;
    private TextView fourButtonText;

    private View fiveButton;
    private TextView fiveButtonText;

    private View sixButton;
    private TextView sixButtonText;


    private View sevenButton;
    private TextView sevenButtonText;

    private View eightButton;
    private TextView eightButtonText;

    private View nineButton;
    private TextView nineButtonText;


    //============================
    private TextView upperCurrency;
    private TextView buttomCurrency;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_currency_convertor, container, false);


        dotButton = (View) view.findViewById(R.id.dot);
        dotButtonText = (TextView) dotButton.findViewById(R.id.button_number);
        dotButtonText.setVisibility(View.VISIBLE);
        dotButtonText.setText(getResources().getString(R.string.dot_button_text));
        dotButton.setOnClickListener(this);


        zeroButton = (View) view.findViewById(R.id.zero);
        zeroButtonText = (TextView) zeroButton.findViewById(R.id.button_number);
        zeroButtonText.setVisibility(View.VISIBLE);
        zeroButtonText.setText(getResources().getString(R.string.zero_button_text));
        zeroButton.setOnClickListener(this);


        backButton = (View) view.findViewById(R.id.back);
        backButtonImg = (ImageView) backButton.findViewById(R.id.button_number);
        backButtonImg.setVisibility(View.VISIBLE);
        backButton.setOnClickListener(this);


        oneButton = (View) view.findViewById(R.id.one);
        oneButtonText = (TextView) oneButton.findViewById(R.id.button_number);
        oneButtonText.setVisibility(View.VISIBLE);
        oneButtonText.setText(getResources().getString(R.string.one_button_text));
        oneButton.setOnClickListener(this);

        twoButton = (View) view.findViewById(R.id.two);
        twoButtonText = (TextView) twoButton.findViewById(R.id.button_number);
        twoButtonText.setVisibility(View.VISIBLE);
        twoButtonText.setText(getResources().getString(R.string.two_button_text));
        twoButton.setOnClickListener(this);

        threeButton = (View) view.findViewById(R.id.three);
        threeButtonText = (TextView) threeButton.findViewById(R.id.button_number);
        threeButtonText.setVisibility(View.VISIBLE);
        threeButtonText.setText(getResources().getString(R.string.three_button_text));
        threeButton.setOnClickListener(this);


        fourButton = (View) view.findViewById(R.id.four);
        fourButtonText = (TextView) fourButton.findViewById(R.id.button_number);
        fourButtonText.setVisibility(View.VISIBLE);
        fourButtonText.setText(getResources().getString(R.string.four_button_text));
        fourButton.setOnClickListener(this);

        fiveButton = (View) view.findViewById(R.id.five);
        fiveButtonText = (TextView) fiveButton.findViewById(R.id.button_number);
        fiveButtonText.setVisibility(View.VISIBLE);
        fiveButtonText.setText(getResources().getString(R.string.five_button_text));
        fiveButton.setOnClickListener(this);

        sixButton = (View) view.findViewById(R.id.six);
        sixButtonText = (TextView) sixButton.findViewById(R.id.button_number);
        sixButtonText.setVisibility(View.VISIBLE);
        sixButtonText.setText(getResources().getString(R.string.six_button_text));
        sixButton.setOnClickListener(this);


        sevenButton = (View) view.findViewById(R.id.seven);
        sevenButtonText = (TextView) sevenButton.findViewById(R.id.button_number);
        sevenButtonText.setVisibility(View.VISIBLE);
        sevenButtonText.setText(getResources().getString(R.string.seven_button_text));
        sevenButton.setOnClickListener(this);

        eightButton = (View) view.findViewById(R.id.eight);
        eightButtonText = (TextView) eightButton.findViewById(R.id.button_number);
        eightButtonText.setVisibility(View.VISIBLE);
        eightButtonText.setText(getResources().getString(R.string.eight_button_text));
        eightButton.setOnClickListener(this);

        nineButton = (View) view.findViewById(R.id.nine);
        nineButtonText = (TextView) nineButton.findViewById(R.id.button_number);
        nineButtonText.setVisibility(View.VISIBLE);
        nineButtonText.setText(getResources().getString(R.string.nine_button_text));
        nineButton.setOnClickListener(this);


        //=====================
        upperCurrency = (TextView) view.findViewById(R.id.upper_currency);
        upperCurrency = (TextView) view.findViewById(R.id.buttom_currency);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        avInterface.getAVLoadingIndicatorView().hide();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.seven:

                break;

            case R.id.eight:

                break;

            case R.id.nine:

                break;

            case R.id.four:

                break;

            case R.id.five:

                break;

            case R.id.six:

                break;

            case R.id.one:

                break;

            case R.id.two:

                break;

            case R.id.three:

                break;

            case R.id.dot:

                break;

            case R.id.zero:

                break;

            case R.id.back:

                break;
        }
    }
}
