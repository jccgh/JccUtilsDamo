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

public class MineFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment_layout, container, false);
        return view;
    }
}
