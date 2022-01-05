package com.location.picker.model;

public class LocationPickerDetail {

    private double latitude;
    private double longitude;
    private String addressSearched;
    private String addressLine1;
    private String addressLine2;
    private String addressLine2Edited;
    private String cityDetails;
    private String id;
    private String url;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String latLong;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddressSearched() {
        return addressSearched;
    }

    public void setAddressSearched(String addressSearched) {
        this.addressSearched = addressSearched;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine2Edited() {
        return addressLine2Edited;
    }

    public void setAddressLine2Edited(String addressLine2Edited) {
        this.addressLine2Edited = addressLine2Edited;
    }

    public String getCityDetails() {
        return cityDetails;
    }

    public void setCityDetails(String cityDetails) {
        this.cityDetails = cityDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }
}
