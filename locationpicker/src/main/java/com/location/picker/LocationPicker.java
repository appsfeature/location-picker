package com.location.picker;

import android.content.Context;
import android.content.Intent;

import com.location.picker.activity.LocationPickerActivity;
import com.location.picker.interfaces.LocationPickerCallback;
import com.location.picker.model.LocationPickerDetail;
import com.location.picker.util.LocationConstants;

public class LocationPicker {

    private static volatile LocationPicker instance;
    public String apiKey = "";
    private boolean isEnableSearchBar = true;
    private boolean isEnableAddressLine1 = true;
    private boolean isEnableAddressLine2 = true;
    private boolean isEnableCityDetails = true;
    private boolean isEnableButtonMap = true;
    private boolean isEnableTranslucentStatus = false;
    private boolean isEnableButtonDirection = true;
    private LocationPickerCallback locationPickerCallback;
    private String hintAddressLine1;

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
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isEnableSearchBar() {
        return isEnableSearchBar;
    }

    public LocationPicker setEnableSearchBar(boolean isEnableSearchBar) {
        this.isEnableSearchBar = isEnableSearchBar;
        return this;
    }

    public String getHintAddressLine1() {
        return hintAddressLine1;
    }

    public LocationPicker setHintAddressLine1(String hintAddressLine1) {
        this.hintAddressLine1 = hintAddressLine1;
        return this;
    }

    public boolean isEnableAddressLine1() {
        return isEnableAddressLine1;
    }

    public LocationPicker setEnableAddressLine1(boolean enableAddressLine1) {
        isEnableAddressLine1 = enableAddressLine1;
        return this;
    }

    public boolean isEnableAddressLine2() {
        return isEnableAddressLine2;
    }

    public LocationPicker setEnableAddressLine2(boolean enableAddressLine2) {
        isEnableAddressLine2 = enableAddressLine2;
        return this;
    }

    public boolean isEnableCityDetails() {
        return isEnableCityDetails;
    }

    public LocationPicker setEnableCityDetails(boolean enableCityDetails) {
        isEnableCityDetails = enableCityDetails;
        return this;
    }

    public boolean isEnableButtonMap() {
        return isEnableButtonMap;
    }

    public LocationPicker setEnableButtonMap(boolean isEnableButtonMap) {
        this.isEnableButtonMap = isEnableButtonMap;
        return this;
    }

    public boolean isEnableButtonDirection() {
        return isEnableButtonDirection;
    }

    public LocationPicker setEnableButtonDirection(boolean isEnableButtonDirection) {
        this.isEnableButtonDirection = isEnableButtonDirection;
        return this;
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
        return isEnableTranslucentStatus;
    }

    public LocationPicker setEnableTranslucentStatus(boolean enableTranslucentStatus) {
        isEnableTranslucentStatus = enableTranslucentStatus;
        return this;
    }
}