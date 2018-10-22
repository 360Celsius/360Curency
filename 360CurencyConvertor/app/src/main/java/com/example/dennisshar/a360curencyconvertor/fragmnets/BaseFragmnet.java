package com.example.dennisshar.a360curencyconvertor.fragmnets;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.dennisshar.a360curencyconvertor.interfaces.AVLoadingIndicatorViewInterface;
import com.example.dennisshar.a360curencyconvertor.interfaces.DataBaseHelperInterface;

public class BaseFragmnet extends Fragment {

    public DataBaseHelperInterface mCallback;
    public AVLoadingIndicatorViewInterface avInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DataBaseHelperInterface) activity;
        avInterface = (AVLoadingIndicatorViewInterface) activity;
    }
}
