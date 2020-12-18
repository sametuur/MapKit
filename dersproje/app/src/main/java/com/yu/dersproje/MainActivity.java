package com.yu.dersproje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.MapView;
import com.huawei.hms.maps.MapsInitializer;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.MarkerOptions;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "MapViewDemoActivity";
    //HUAWEI map
    private HuaweiMap hMap;

    private MapView mMapView;

    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = findViewById(R.id.mapView);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }

        MapsInitializer.setApiKey("CgB6e3x9a2xeMkEmPfII/Dw4COmueBj/8fGWqLCnrT9UDLFjujC2qF1OG2JKttRiTHZrxQSHwUCK0Wr27LHGFh+o");
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);


    }

    @Override
    public void onMapReady(HuaweiMap map) {
        Log.d(TAG, "onMapReady: ");
        hMap = map;
        hMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(41.015137,28.979530),10));
        hMap.addMarker(new MarkerOptions().position(new LatLng(38.43517288455261, 27.178001754806342)).title("İzmir Atatürk Stadyumu").clusterable(true));
        hMap.addMarker( new MarkerOptions().position(new LatLng(41.11648275835911, 28.77268698228928)).title("Atatürk Olimpiyat Stadyumu").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(new LatLng(41.1033254328508, 28.99126321450057)).title("Türk Telekom Stadyumu").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(new LatLng(40.98801673310454, 29.036855483730665)).title("Fenerbahçe Şükrü Saracoğlu Stadyumu").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(new LatLng(40.21102300568237, 29.009489070209693)).title("Bursa Büyükşehir Belediye Stadyumu").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(new LatLng(37.946431213290076, 32.488020725954506)).title("Konya Büyükşehir Belediye Stadyumu").clusterable(true));
        hMap.addMarker(new MarkerOptions().position( new LatLng(41.03954913297954, 28.994130154896872)).title("Vodafone Park").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(new LatLng(39.93194410736002, 32.87220081252887)).title("Cebeci İnönü Stadyumu").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(new LatLng(40.79592910955514, 30.02032977210162)).title("Kocaeli Stadyumu").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(new LatLng(41.27093970823014, 36.35457367268538)).title("Samsun 19 Mayıs Stadyumu").clusterable(true));
        hMap.setMarkersClustering(true);
        hMap.setOnMarkerClickListener(new HuaweiMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker ) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("anahtar", marker.getTitle());
                startActivity(intent);
                return false;
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
    private Marker mMarker;
    public void addMarker(View view) {
        if (null != mMarker) {
            mMarker.remove();
        }
        MarkerOptions options = new MarkerOptions()
                .position(new LatLng(41.27093970823014, 41.27093970823014))
                .title("SAMET UGUR ASLAN")
                .snippet("HA BURADAYIM HA!");

        mMarker = hMap.addMarker(options);
    }

}
