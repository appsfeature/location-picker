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
        LocationPicker.getInstance()
                .setEnableSearchBar(true)
                .setEnableAddressLine1(true)
                .setEnableAddressLine2(true)
                .setEnableCityDetails(true)
                .setEnableTranslucentStatus(true)
                .setHintAddressLine1("Shop Detail")
                .setApiKey(getString(R.string.google_api_key));
    }
}