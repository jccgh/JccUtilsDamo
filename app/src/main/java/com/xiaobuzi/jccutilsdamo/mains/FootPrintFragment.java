package com.xiaobuzi.jccutilsdamo.mains;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaobuzi.jccutilsdamo.R;
import com.xiaobuzi.jccutilsdamo.base.BaseFragment;

/**
 * Created by JCC on 2017/3/23.
 */

public class FootPrintFragment extends BaseFragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.foot_fragment_layout, container, false);
        initData();
        return mView;
    }

    private void initData() {

    }
}
