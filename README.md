# location-picker
##Before you begin:
##Required for Search Bar: ###Before you start using the Places SDK for Android, you need a project with a billing account and the Places API enabled. We recommend creating multiple Project Owners and Billing Administrators, so that you'll always have someone with these roles available to your team. To learn more, see Set up in Cloud Console.

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

        google_places = '2.5.0'
    }
}
```

Add this to your project build.gradle

#### Dependency
[![](https://jitpack.io/v/appsfeature/location-picker.svg)](https://jitpack.io/#appsfeature/location-picker)
```gradle
dependencies {
    implementation 'com.github.appsfeature:location-picker:1.4'
}
```
Needed support libs
```gradle
dependencies {
    implementation "androidx.appcompat:appcompat:$rootProject.ext.appcompat"
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
        LocationPicker.getInstance().open(this);
    }

    @Override
    public void onLocationSelected(LocationPickerDetail detail) {
        tvStatus.setText(detail.getLatitude() + "," + detail.getLongitude());
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
                .setEnableHouseDetails(true)
                .setApiKey(getString(R.string.google_api_key));
    }
}
```
### Need to Add google-services.json file in app root directory.
```java
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
