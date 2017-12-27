package com.liangke.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by LK on 2017/12/19.
 */

public class HorizontalListView extends RecyclerView {

    private HorizontalListManager manager;

    public HorizontalListView(Context context) {
        super(context);
        init();
    }

    public HorizontalListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    private void init(){
        manager = new HorizontalListManager(getContext(),this);
    }


    public HorizontalListManager getManager() {
        return manager;
    }

    public void setManager(HorizontalListManager manager) {
        this.manager = manager;
    }
}
