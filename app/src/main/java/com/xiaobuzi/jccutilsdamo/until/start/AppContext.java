package com.xiaobuzi.jccutilsdamo.until.start;

import android.content.Context;

/**
 * Created by JCC on 2017/3/10.
 */

public class AppContext {
    private final static boolean isDebug = false;//BuildConfig.DEBUG;

    private static Context context = null;
    private static AppContext appContext = null;

    private AppContext() {
    }

    public void SetAppContext(Context context) {
        AppContext.context = context;
    }

    public static AppContext getInstance(){
        if(appContext == null){
            appContext = new AppContext();
        }
        return appContext;
    }

    public static Context getAppContext(){
        return AppContext.context;
    }

    public static boolean isDebug(){
        return isDebug;
    }

}
