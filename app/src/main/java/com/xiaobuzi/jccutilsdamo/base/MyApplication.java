package com.xiaobuzi.jccutilsdamo.base;

import android.app.Application;

import com.xiaobuzi.jccutilsdamo.until.start.AppContext;

/**
 * Created by JCC on 2017/3/23.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.getInstance().SetAppContext(this);
    }
}
