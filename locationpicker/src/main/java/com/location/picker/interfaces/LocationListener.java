package com.location.picker.interfaces;

import com.location.picker.model.LocationPickerDetail;

public interface LocationListener {

    void onLocationSelected(LocationPickerDetail detail);
    void onCanceled(Exception e);
}
