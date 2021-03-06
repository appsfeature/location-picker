package com.sample.locationpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.location.picker.interfaces.LocationPickerCallback;
import com.location.picker.LocationPicker;
import com.location.picker.model.LocationPickerDetail;
import com.location.picker.util.CountryCode;

public class MainActivity extends AppCompatActivity implements LocationPickerCallback {
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = findViewById(R.id.tv_status);
    }

    public void onPick(View view) {
        LocationPicker.getInstance()
                .setLocationCallback(this)
                .open(this, CountryCode.India);
    }

    @Override
    public void onLocationSelected(LocationPickerDetail detail) {
        tvStatus.setText(detail.getLatLong());
    }

    @Override
    public void onCanceled(Exception e) {

    }
}