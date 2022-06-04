package com.location.picker.interfaces;

import com.location.picker.LocationPicker;

public class LocationProperties {

    public String apiKey = "";
    public boolean isEnableSearchBar = true;
    public boolean isEnableAddressLine1 = true;
    public boolean isEnableAddressLine2 = true;
    public boolean isEnableCityDetails = true;
    public boolean isEnableButtonMap = true;
    public boolean isEnableButtonDirection = true;
    public boolean isEnableTranslucentStatus = true;
    public String hintAddressLine1;

    public static LocationProperties Builder() {
        return new LocationProperties();
    }

    public String getApiKey() {
        return apiKey;
    }

    public LocationProperties setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public LocationProperties setEnableSearchBar(boolean enableSearchBar) {
        isEnableSearchBar = enableSearchBar;
        return this;
    }

    public LocationProperties setEnableAddressLine1(boolean enableAddressLine1) {
        isEnableAddressLine1 = enableAddressLine1;
        return this;
    }

    public LocationProperties setEnableAddressLine2(boolean enableAddressLine2) {
        isEnableAddressLine2 = enableAddressLine2;
        return this;
    }

    public LocationProperties setEnableCityDetails(boolean enableCityDetails) {
        isEnableCityDetails = enableCityDetails;
        return this;
    }

    public LocationProperties setEnableButtonMap(boolean enableButtonMap) {
        isEnableButtonMap = enableButtonMap;
        return this;
    }

    public LocationProperties setEnableButtonDirection(boolean enableButtonDirection) {
        isEnableButtonDirection = enableButtonDirection;
        return this;
    }

    public LocationProperties setEnableTranslucentStatus(boolean enableTranslucentStatus) {
        isEnableTranslucentStatus = enableTranslucentStatus;
        return this;
    }

    public LocationProperties setHintAddressLine1(String hintAddressLine1) {
        this.hintAddressLine1 = hintAddressLine1;
        return this;
    }
}
