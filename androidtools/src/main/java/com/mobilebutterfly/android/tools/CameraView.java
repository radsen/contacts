package com.mobilebutterfly.android.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/**
 * Created by radsen on 11/21/15.
 */
public class CameraView extends TextureView {

    private int mRatioWidth;
    private int mRatioHeight;

    public CameraView(Context context) {
        super(context);
    }

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CameraView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setAspectRatio(int width, int height){
        if(width < 0 || height < 0){
            throw new IllegalArgumentException();
        }

        mRatioWidth = width;
        mRatioHeight = height;

        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if(mRatioWidth == 0 || mRatioHeight == 0){
            setMeasuredDimension(width, height);
        }else{
            if(width < height * mRatioWidth /mRatioHeight){
                setMeasuredDimension(width, width * mRatioHeight/ mRatioWidth);
            } else {
                setMeasuredDimension(height * mRatioWidth /mRatioHeight, height);
            }
        }
    }
}
