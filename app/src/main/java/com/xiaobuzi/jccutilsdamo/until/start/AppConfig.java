package com.xiaobuzi.jccutilsdamo.until.start;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * 数据持久化
 * Created by zhuangaH on 2016-11-1.
 */

public class AppConfig extends BaseConfig {


    private static AppConfig appConfig = null;
    /**
     * 设备号
     */
    private static String equipmentnumber = "EQUIPMENT_NUMBER";


    //是否登陆
    public final static String IS_AUTO = "auto";



    private AppConfig() {

    }


    public static AppConfig getInstance() {
        if (appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }

    public static void setEquipmentNumber(String clientid) {
        set(equipmentnumber, clientid);
    }

    public static String getequipmentNumber() {
        return get(equipmentnumber);
    }

    public static void setAuto(boolean isAuto) {
        if (isAuto) {
            set(IS_AUTO, "1");
        } else {
            set(IS_AUTO, "0");
        }
    }

    public static boolean isAuto() {
        return "1".equals(get(IS_AUTO));
//                return true;
    }


    /**
     * 获取本机串号imei
     */
    public static void getDeviceNumber(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        AppConfig.setEquipmentNumber(telephonyManager.getDeviceId());
    }



}

