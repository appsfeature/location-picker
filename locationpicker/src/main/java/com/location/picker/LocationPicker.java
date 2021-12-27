package com.location.picker;

import android.content.Context;
import android.content.Intent;

import com.location.picker.activity.LocationPickerActivity;
import com.location.picker.interfaces.LocationPickerCallback;
import com.location.picker.model.LocationPickerDetail;

public class LocationPicker {

    private static volatile LocationPicker instance;
    public String apiKey = "";
    private boolean isEnableSearchBar = true;
    private boolean isEnableHouseDetails = true;
    private boolean isEnableButtonMap = true;
    private boolean isEnableButtonDirection = true;
    private LocationPickerCallback locationPickerCallback;

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

    public boolean isEnableHouseDetails() {
        return isEnableHouseDetails;
    }

    public LocationPicker setEnableHouseDetails(boolean isEnableHouseDetails) {
        this.isEnableHouseDetails = isEnableHouseDetails;
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
        this.locationPickerCallback = ((LocationPickerCallback) context);
        context.startActivity(new Intent(context, LocationPickerActivity.class));
    }

    public void updateCallback(LocationPickerDetail detail) {
        if (locationPickerCallback != null) {
            locationPickerCallback.onLocationSelected(detail);
        }
    }
}