package com.location.picker.base;

import android.content.Context;
import android.content.Intent;

import com.location.picker.LocationPicker;
import com.location.picker.activity.LocationPickerActivity;
import com.location.picker.interfaces.LocationPickerCallback;
import com.location.picker.interfaces.LocationProperties;
import com.location.picker.model.LocationPickerDetail;
import com.location.picker.util.LocationConstants;

public class LocationPickerClass implements LocationPicker {

    private static volatile LocationPickerClass instance;

    private LocationPickerCallback locationPickerCallback;
    private LocationProperties property;

    private LocationPickerClass() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static LocationPickerClass Builder() {
        if (instance == null) {
            synchronized (LocationPickerClass.class) {
                if (instance == null) instance = new LocationPickerClass();
            }
        }
        return instance;
    }

    @Override
    public String getApiKey() {
        return getProperty().apiKey;
    }

    @Override
    public boolean isEnableSearchBar() {
        return getProperty().isEnableSearchBar;
    }

    @Override
    public String getHintAddressLine1() {
        return getProperty().hintAddressLine1;
    }

    @Override
    public boolean isEnableAddressLine1() {
        return getProperty().isEnableAddressLine1;
    }

    @Override
    public boolean isEnableAddressLine2() {
        return getProperty().isEnableAddressLine2;
    }

    @Override
    public boolean isEnableCityDetails() {
        return getProperty().isEnableCityDetails;
    }

    @Override
    public boolean isEnableButtonMap() {
        return getProperty().isEnableButtonMap;
    }

    @Override
    public boolean isEnableButtonDirection() {
        return getProperty().isEnableButtonDirection;
    }

    @Override
    public LocationPickerClass setLocationCallback(LocationPickerCallback locationPickerCallback) {
        this.locationPickerCallback = locationPickerCallback;
        return this;
    }

    @Override
    public void open(Context context) {
        open(context, "");
    }

    @Override
    public void open(Context context, String countryIsoCode) {
        context.startActivity(new Intent(context, LocationPickerActivity.class)
                .putExtra(LocationConstants.COUNTRY_ISO_CODE, countryIsoCode));
    }

    @Override
    public void updateCallback(LocationPickerDetail detail) {
        if (locationPickerCallback != null) {
            locationPickerCallback.onLocationSelected(detail);
        }
    }

    @Override
    public boolean isEnableTranslucentStatus() {
        return getProperty().isEnableTranslucentStatus;
    }

    @Override
    public void setProperty(LocationProperties property) {
        this.property = property;
    }

    @Override
    public LocationProperties getProperty() {
        return property == null ? new LocationProperties() : property;
    }
}