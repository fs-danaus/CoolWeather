package com.coolweather.android;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

public class ChooseAreaFragment extends Fragment {
    public static final int LEVEL_PROVINCE=0;
    public static final int LEVEL_CITY=1;
    public static final int LEVEL_COUNTY=2;
    private ProgressDialog mProgressDialog;
    private TextView mTextView;
    private Button mButton;
    private RecyclerView mRecyclerView;

}
