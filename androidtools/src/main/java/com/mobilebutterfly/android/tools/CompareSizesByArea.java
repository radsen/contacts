package com.mobilebutterfly.android.tools;

import android.util.Size;

import java.util.Comparator;

/**
 * Created by radsen on 11/21/15.
 */
public class CompareSizesByArea implements Comparator<Size> {

    @Override
    public int compare(Size lhs, Size rhs) {
        return Long.signum((long) lhs.getWidth() * lhs.getHeight() -
                (long) rhs.getWidth() * rhs.getHeight());
    }
}
