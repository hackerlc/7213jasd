package com.liangke.popupwindow;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.github.mikephil.charting.data.LineDataSet;
import com.liangke.adapter.ChannelAdapter;
import com.liangke.adapter.StockjobberAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.PopuoStockjobberBinding;
import com.liangke.mvvm.bean.StockjobberBean;
import com.liangke.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/26.
 */

public class StockjobberPopupWindow {

    private Context mContext;
    private PopuoStockjobberBinding binding;
    private PopupWindow popupWindow;
    private StockjobberAdapter adapter;
    public StockjobberPopupWindow(Context mContext) {
        this.mContext = mContext;
        init();
    }

    private void init(){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = DataBindingUtil.inflate(inflater, R.layout.popuo_stockjobber,null,false);
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        int width = metrics.widthPixels- Utils.getScaleByDensity(mContext,100);
        popupWindow = new PopupWindow(binding.getRoot(), width, WindowManager.LayoutParams.WRAP_CONTENT);

        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);


        List<StockjobberBean> list = new ArrayList<>();
        for(int i = 0;i<5;i++){
            list.add(new StockjobberBean("测试"+i));
        }
        binding.rvList.setLayoutManager(new LinearLayoutManager(mContext));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(mContext,R.drawable.devider_item));
        binding.rvList.addItemDecoration(dividerItemDecoration);

        adapter = new StockjobberAdapter(mContext,list);
        binding.rvList.setAdapter(adapter);


    }


    public void showAtLocation(View parent, int gravity, int x, int y) {
        popupWindow.showAtLocation(parent,gravity,x,y);
    }

    public interface OnItemClickListener{
        public void onItemClick(StockjobberBean bean);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        adapter.setOnItemClickListener(onItemClickListener);
    }


}
