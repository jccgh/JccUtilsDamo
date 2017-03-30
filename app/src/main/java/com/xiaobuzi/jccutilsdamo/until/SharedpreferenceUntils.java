package com.xiaobuzi.jccutilsdamo.until;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Created by JCC on 2017/3/23.
 */

public class SharedpreferenceUntils {
    private static Context mContext;
    private static SharedpreferenceUntils spuntils;
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;

    private SharedpreferenceUntils() {
    }

    public static void initialize(Context context){
        mContext = context;
    }
    public static SharedpreferenceUntils getInstense(String data) {

        if (spuntils != null) {
            spuntils = null;
        }
        if (sp != null) {
            sp = null;
        }
        if (editor != null) {
            editor.clear();
            editor = null;
        }
        sp = mContext.getSharedPreferences(data, Context.MODE_PRIVATE);
        editor = sp.edit();
        spuntils = new SharedpreferenceUntils();
        return spuntils;
    }

    public void putString(String key, String value) {

        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key, int delValue) {
        return sp.getInt(key, delValue);
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();

    }

    public boolean getBoolean(String key, boolean delValue) {
        return sp.getBoolean(key, delValue);
    }

    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public float getFloat(String key, float delValue) {
        return sp.getFloat(key, delValue);
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLong(String key, long delValue) {
        return sp.getLong(key, delValue);
    }

    public void putStirngSet(String key, Set<String> values) {
        editor.putStringSet(key, values);
        editor.commit();
    }

    public Set<String> getStringSet(String key, Set<String> delValue) {
        return sp.getStringSet(key, delValue);
    }
}
