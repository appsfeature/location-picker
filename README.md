# location-picker
## Before you begin:

#### Basic Requirements for Search Bar:
#### Before you start using the Places SDK for Android, you need a project with a billing account and the Places API enabled. We recommend creating multiple Project Owners and Billing Administrators, so that you'll always have someone with these roles available to your team. To learn more, see Set up in Cloud Console.

*Search any location using Google Places Library
*Pick any location from the map
*Edit Location and add more Details

<p align="left">
  <img src="https://raw.githubusercontent.com/appsfeature/location-picker/master/screenshots/sample1.png" alt="Preview 1" width="250" />
  <img src="https://raw.githubusercontent.com/appsfeature/location-picker/master/screenshots/sample2.png" alt="Preview 2" width="250" />
</p>

  
## Setup Project

Add this to your project build.gradle
``` gradle
allprojects {
    repositories {
        maven {
            url "https://jitpack.io"
        }
    }

    ext {
        appcompat = '1.3.0'
        material = '1.3.0'

        google_places = '2.5.0'
    }
}
```

Add this to your project build.gradle

#### Dependency
[![](https://jitpack.io/v/appsfeature/location-picker.svg)](https://jitpack.io/#appsfeature/location-picker)
```gradle
dependencies {
    implementation 'com.github.appsfeature:location-picker:2.3'
}
```
Needed support libs
```gradle
dependencies {
    implementation "androidx.appcompat:appcompat:$rootProject.ext.appcompat"
    implementation "com.google.android.material:material:$rootProject.ext.material"
}
```


### Usage methods
```java
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
```

```java
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
                .setHintAddressLine1("Enter Shop Detail")
                .setApiKey(getString(R.string.google_api_key));
    }
}
```
### Need to Add google-services.json file in app root directory.
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.sample.locationpicker">

    <application
        ...
        ...
        android:theme="@style/AppTheme">

        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/google_api_key" />
    </application>

</manifest>
```
### Customise Xml resources
```xml
    <!--  Customise String resources  -->
    <string name="button_continue_text">Continue</string>
    <string name="show_location_picker">Show Location Picker</string>
    <string name="address_line1_hint">Enter Flat No / Floor / Landmark </string>
    <string name="address_line2_hint">Address Line 2</string>
    <string name="city_detail_hint">City Detail</string>

    <!--  Customise Dimens resources  -->
    <dimen name="location_edittext_size">12sp</dimen>
    <dimen name="location_edittext_search_bar_size">16sp</dimen>
```
