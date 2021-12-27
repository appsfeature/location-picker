package com.sample.locationpicker;

import android.app.Application;

import com.location.picker.LocationPicker;

public class AppApplication extends Application {
    private static AppApplication instance;

    public static AppApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        LocationPicker.getInstance()
                .setEnableSearchBar(true)
                .setEnableHouseDetails(true)
                .setApiKey(getString(R.string.google_api_key));
    }
}