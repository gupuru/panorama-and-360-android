package com.gupuru.panoramaand360;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

/**
 * パノラマ
 */
public class PanoramaActivity extends AppCompatActivity {

    private GyroscopeObserver gyroscopeObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panorama);
        gyroscopeObserver = new GyroscopeObserver();

        PanoramaImageView panoramaImageView = (PanoramaImageView) findViewById(R.id.panorama_image_view);
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);

    }

    @Override
    public void onPause() {
        super.onPause();
        gyroscopeObserver.unregister();

    }

    @Override
    public void onResume() {
        super.onResume();
        gyroscopeObserver.register(this);

    }

}
