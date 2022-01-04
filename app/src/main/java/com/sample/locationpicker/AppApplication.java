package com.sample.locationpicker;

import android.app.Application;

import com.google.android.libraries.places.api.Places;
import com.location.picker.LocationPicker;

import java.util.Locale;

public class AppApplication extends Application {
    private static AppApplication instance;

    public static AppApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), getString(R.string.google_api_key), Locale.US);
        }
        LocationPicker.getInstance()
                .setEnableSearchBar(true)
                .setEnableHouseDetails(true)
                .setApiKey(getString(R.string.google_api_key));
    }
}