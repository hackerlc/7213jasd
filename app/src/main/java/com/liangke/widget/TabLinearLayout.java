package com.liangke.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/13.
 */

public class TabLinearLayout extends LinearLayout {

    private final String TAG = TabLinearLayout.class.getSimpleName();

    private TabManager tabManager;
    private TabDisplayMetrics displayMetrics;
    private List<TabView> tabViewList = new ArrayList<>();
    public TabLinearLayout(Context context) {
        super(context);
        init();
    }

    public TabLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TabLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TabLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        tabManager = new TabManager(this);
        setOrientation(HORIZONTAL);
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

    public TabManager getTabManager() {
        return tabManager;
    }

    public void setTabManager(TabManager tabManager) {
        this.tabManager = tabManager;
    }

    private float getFontScale(float spValue) {
        float fontSize = getContext().getResources().getDisplayMetrics().scaledDensity;
        float value = spValue * fontSize + 0.5f;
        return value;
    }

    private int getScaleByDensity(int dpValue) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        int value = (int) (dpValue * scale + 0.5f);
        return value;
    }

    @Override
    public void invalidate() {
        if(tabViewList.size()==0){
            for(int i = 0;i<tabManager.getmList().size();i++){
                TabContent tabContent = tabManager.getmList().get(i);

                TabView tabView = new TabView(tabContent);
                addView(tabView.getLinearLayout());
                tabViewList.add(tabView);

                if(i==tabManager.getSelectedPosition()){
                    tabView.showSelcted();
                }else{
                    tabView.showUnSelected();
                }

                final int finalI = i;

                tabView.linearLayout.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tabManager.setSelectedPosition(finalI);
                        invalidate();
                    }
                });
            }
        }else{
            for(int i = 0;i<tabViewList.size();i++){
                TabContent tabContent = tabManager.getmList().get(i);
                TabView tabView = tabViewList.get(i);

                if(i==tabManager.getSelectedPosition()){
                    tabView.showSelcted();
                }else{
                     tabView.showUnSelected();
                }
            }
        }

        super.invalidate();

    }

    private int getColor(int color_res){
        return ContextCompat.getColor(getContext(),color_res);
    }

    public class TabView{
        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;
        boolean isShowImg = false;
        boolean isShowTxt = false;
        TabContent tabContent;
        public TabView(TabContent tabContent) {
            this.tabContent = tabContent;
            linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(VERTICAL);
            linearLayout.setGravity(Gravity.CENTER);
            LayoutParams params = (LayoutParams) linearLayout.getLayoutParams();
            if(params==null){
                params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            }
            params.weight = 1;
            linearLayout.setLayoutParams(params);

            if(tabContent.tab_img_selected!=0&&tabContent.tab_img_unselected!=0){
                isShowImg = true;
                initImageView();
            }

            if(tabContent.tab_txt!=null){
                isShowTxt = true;
                initTextView();
            }

        }

        public void initImageView(){
            imageView = new ImageView(getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(getScaleByDensity(tabContent.tab_img_width),getScaleByDensity(tabContent.tab_img_height)));
            linearLayout.addView(imageView);
        }

        public void initTextView(){

            textView = new TextView(getContext());
            textView.setGravity(Gravity.CENTER);
            textView.getLayoutParams();
            textView.setText(tabContent.tab_txt);
            textView.setTextSize(tabContent.tab_txt_size);

            linearLayout.addView(textView);

        }

        public void showSelcted(){
            if(isShowImg){
                imageView.setImageResource(tabContent.tab_img_selected);
            }
            if(isShowTxt){
                textView.setTextColor(ContextCompat.getColor(getContext(),tabContent.tab_txtColor_selected));
            }

        }

        public void showUnSelected(){
            if(isShowImg){
                imageView.setImageResource(tabContent.tab_img_unselected);
            }
            if(isShowTxt){
                textView.setTextColor(ContextCompat.getColor(getContext(),tabContent.tab_txtColor_unslected));
            }
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }
    }






}
