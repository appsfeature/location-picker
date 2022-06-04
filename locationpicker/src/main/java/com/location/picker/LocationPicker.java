package com.location.picker;

import android.content.Context;
import android.content.Intent;

import com.location.picker.activity.LocationPickerActivity;
import com.location.picker.interfaces.LocationPickerCallback;
import com.location.picker.interfaces.LocationProperties;
import com.location.picker.model.LocationPickerDetail;
import com.location.picker.util.LocationConstants;

public class LocationPicker {

    private static volatile LocationPicker instance;

    private LocationPickerCallback locationPickerCallback;
    private LocationProperties property;

    private LocationPicker() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static LocationPicker getInstance() {
        if (instance == null) {
            synchronized (LocationPicker.class) {
                if (instance == null) instance = new LocationPicker();
            }
        }
        return instance;
    }

    public String getApiKey() {
        return getProperty().apiKey;
    }

    public boolean isEnableSearchBar() {
        return getProperty().isEnableSearchBar;
    }

    public String getHintAddressLine1() {
        return getProperty().hintAddressLine1;
    }

    public boolean isEnableAddressLine1() {
        return getProperty().isEnableAddressLine1;
    }

    public boolean isEnableAddressLine2() {
        return getProperty().isEnableAddressLine2;
    }

    public boolean isEnableCityDetails() {
        return getProperty().isEnableCityDetails;
    }

    public boolean isEnableButtonMap() {
        return getProperty().isEnableButtonMap;
    }

    public boolean isEnableButtonDirection() {
        return getProperty().isEnableButtonDirection;
    }

    public LocationPicker setLocationCallback(LocationPickerCallback locationPickerCallback) {
        this.locationPickerCallback = locationPickerCallback;
        return this;
    }

    public void open(Context context) {
        open(context, "");
    }

    public void open(Context context, String countryIsoCode) {
        context.startActivity(new Intent(context, LocationPickerActivity.class)
                .putExtra(LocationConstants.COUNTRY_ISO_CODE, countryIsoCode));
    }

    public void updateCallback(LocationPickerDetail detail) {
        if (locationPickerCallback != null) {
            locationPickerCallback.onLocationSelected(detail);
        }
    }

    public boolean isEnableTranslucentStatus() {
        return getProperty().isEnableTranslucentStatus;
    }

    public void setProperty(LocationProperties property) {
        this.property = property;
    }

    public LocationProperties getProperty() {
        return property == null ? new LocationProperties() : property;
    }
}