package com.gupuru.panoramaand360;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;

/**
 * 360画像 Activity
 */
public class VrActivity extends AppCompatActivity {

    private VrPanoramaView panoWidgetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr);

        panoWidgetView = (VrPanoramaView) findViewById(R.id.vr_view);
        loadPanoImage();
    }

    @Override
    public void onPause() {
        panoWidgetView.pauseRendering();
        super.onPause();
    }

    @Override
    public void onResume() {
        panoWidgetView.resumeRendering();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        panoWidgetView.shutdown();
        super.onDestroy();
    }

    private void loadPanoImage() {
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        InputStream inputStream = null;

        AssetManager assetManager = getAssets();

        try {
            inputStream = assetManager.open("vr.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            panoWidgetView.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
        } catch (IOException e) {
            Log.e("Tuts+", "Exception in loadPhotoSphere: " + e.getMessage());
        }
    }

}
