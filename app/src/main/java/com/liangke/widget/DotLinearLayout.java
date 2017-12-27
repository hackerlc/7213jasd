package com.liangke.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.liangke.comprehensive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/18.
 */

public class DotLinearLayout extends LinearLayout {

    private int selectedRes = -1;
    private int unSelectedRes = -1;
    private int selectedPosition = 0;
    private int count = 0;

    private List<ImageView> imageViewList = new ArrayList<>();

    public DotLinearLayout(Context context) {
        super(context);
        init();
    }

    public DotLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DotLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DotLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }

    public int getSelectedRes() {
        return selectedRes;
    }

    public void setSelectedRes(int selectedRes) {
        this.selectedRes = selectedRes;
    }

    public int getUnSelectedRes() {
        return unSelectedRes;
    }

    public void setUnSelectedRes(int unSelectedRes) {
        this.unSelectedRes = unSelectedRes;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void invalidate() {

        if(imageViewList.size()==0){
            for(int i = 0;i<count;i++){
                ImageView imageView = new ImageView(getContext());
                LayoutParams params = new LinearLayout.LayoutParams(10,10);
                params.leftMargin = 5;
                params.rightMargin = 5;
                imageView.setLayoutParams(params);
                if(i==selectedPosition){
                    imageView.setBackgroundResource(selectedRes);
                }else{
                    imageView.setBackgroundResource(unSelectedRes);
                }
                addView(imageView);
                imageViewList.add(imageView);
            }
        }else{

            for(int i = 0;i<count;i++){
                ImageView imageView = imageViewList.get(i);
                if(i==selectedPosition){
                    imageView.setBackgroundResource(selectedRes);
                }else{
                    imageView.setBackgroundResource(unSelectedRes);
                }
            }

        }

        super.invalidate();

    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        invalidate();
    }
}
