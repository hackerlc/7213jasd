package com.liangke.widget;

import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/13.
 */

public class TabManager {

    private List<TabContent> mList = new ArrayList<>();
    private TabLinearLayout linearLayout;
    private OnSelectedPositionListener onSelectedPositionListener;
    private int selectedPosition = 0;

    public TabManager(TabLinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }

    public List<TabContent> getmList() {
        return mList;
    }

    public void setmList(List<TabContent> mList) {
        this.mList.addAll(mList);
        linearLayout.invalidate();
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int finalI) {
        selectedPosition = finalI;
        if(onSelectedPositionListener!=null){
            onSelectedPositionListener.onSelectedPositionListener(finalI);
        }
    }

    public interface OnSelectedPositionListener{
         public void onSelectedPositionListener(int position);
    }

    public OnSelectedPositionListener getOnSelectedPositionListener() {
        return onSelectedPositionListener;
    }

    public void setOnSelectedPositionListener(OnSelectedPositionListener onSelectedPositionListener) {
        this.onSelectedPositionListener = onSelectedPositionListener;
    }
}
