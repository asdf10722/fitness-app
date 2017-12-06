package com.example.yinhen.project1.libs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.util.Base64;

import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by user on 2017/12/6.
 */

public class Preference {

    private static SharedPreferences appSharedPrefs;
    private static SharedPreferences.Editor prefsEditor;


    @SuppressLint("CommitPrefEdits")
    private static void init(Context context) {
        appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefsEditor = appSharedPrefs.edit();
    }

    public static int getInt(Context context, String key, int defValue) {
        init(context);

        return appSharedPrefs.getInt(key, defValue);
    }

    public static void setInt(Context context, String key, int value) {
        init(context);

        prefsEditor.putInt(key, value);
        prefsEditor.commit();
    }

    public static long getLong(Context context, String key, long defValue) {
        init(context);

        return appSharedPrefs.getLong(key, defValue);
    }

    public static void setLong(Context context, String key, long value) {
        init(context);

        prefsEditor.putLong(key, value);
        prefsEditor.commit();
    }

    public static float getFloat(Context context, String key, float defValue) {
        init(context);

        return appSharedPrefs.getFloat(key, defValue);
    }

    public static void setFloat(Context context, String key, float value) {
        init(context);

        prefsEditor.putFloat(key, value);
        prefsEditor.commit();
    }

    public static String getString(Context context, String key, String defValue) {
        init(context);

        return appSharedPrefs.getString(key, defValue);
    }

    public static void setString(Context context, String key, String data) {
        init(context);

        prefsEditor.putString(key, data);
        prefsEditor.commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        init(context);

        return appSharedPrefs.getBoolean(key, defValue);
    }

    public static void setBoolean(Context context, String key, boolean data) {
        init(context);

        prefsEditor.putBoolean(key, data);
        prefsEditor.commit();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Object getObject(Context context, String key, Class cls) {
        init(context);

        String json = appSharedPrefs.getString(key, null);

        return new Gson().fromJson(json, cls);
    }

    public static void setObject(Context context, String key, Object data) {
        init(context);

        String json = new Gson().toJson(data);
        prefsEditor.putString(key, json);
        prefsEditor.commit();
    }


    private static void setImageBitmap(Context context, String key, Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        setString(context, key, imageString);
    }

    private Bitmap getImageBitmap(Context context, String key, Bitmap defBitmap) {
        String imageString = getString(context, key, "");
        if (imageString.equals("")) return defBitmap;
        byte[] byteArray = Base64.decode(getString(context, imageString, ""), Base64.DEFAULT);
        if (byteArray == null) return defBitmap;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        return BitmapFactory.decodeStream(byteArrayInputStream);
    }
}
