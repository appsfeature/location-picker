package com.location.picker;

import android.content.Context;

import com.location.picker.base.LocationPickerClass;
import com.location.picker.interfaces.LocationPickerCallback;
import com.location.picker.interfaces.LocationProperties;
import com.location.picker.model.LocationPickerDetail;

public interface LocationPicker {

    String getApiKey();

    boolean isEnableSearchBar();

    String getHintAddressLine1();

    boolean isEnableAddressLine1();
    boolean isEnableAddressLine2();
    boolean isEnableCityDetails();
    boolean isEnableButtonMap();
    boolean isEnableButtonDirection();
    LocationPicker setLocationCallback(LocationPickerCallback locationPickerCallback);

    static LocationPicker getInstance() {
        return LocationPickerClass.Builder();
    }

    void open(Context context);
    void open(Context context, String countryIsoCode);

    void updateCallback(LocationPickerDetail detail);

    boolean isEnableTranslucentStatus();
    void setProperty(LocationProperties property);
    LocationProperties getProperty();
}