package com.mobilebutterfly.contacts;

import android.hardware.Camera;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    SurfaceView preview;
    private CameraPreview mPreview;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        preview = (SurfaceView) view.findViewById(R.id.camera_preview);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(MBCamUtils.isCameraAvailable(getActivity())){

            // Create an instance of Camera
            Camera camera = MBCamUtils.getCameraInstance();

            // Create our Preview view and set it as the content of our activity.
            mPreview = new CameraPreview(preview, camera);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
