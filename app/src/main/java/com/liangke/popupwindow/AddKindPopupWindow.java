package com.liangke.popupwindow;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.adapter.ChannelAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemChannelBinding;
import com.liangke.comprehensive.databinding.PopupAddkindBinding;
import com.liangke.mvvm.bean.ChannelBean;
import com.liangke.mvvm.bean.NewsclassifierBean;
import com.liangke.mvvm.bean.ProductSelectBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/18.
 */

public class AddKindPopupWindow {

    private Context mContext;
    private LayoutInflater inflater;
    private PopupAddkindBinding binding;
    private PopupWindow popupWindow;

    private List<ChannelBean> selectedList = new ArrayList<>();
    private List<ChannelBean> unSelectedList = new ArrayList<>();

    private ChannelAdapter selectedAdapter,unSelectedAdapter;


    public AddKindPopupWindow(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
        init();
    }

    private void init(){
        binding = DataBindingUtil.inflate(inflater,R.layout.popup_addkind,null,false);
        popupWindow = new PopupWindow(binding.getRoot(),WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);


        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);

        //点击外围消失
        RxView.clicks(binding.llCancel).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                popupWindow.dismiss();
            }
        });
        //完成
        RxView.clicks(binding.bOk).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                popupWindow.dismiss();
            }
        });

        binding.rvSelected.setLayoutManager(new GridLayoutManager(mContext,4));
        binding.rvUnselected.setLayoutManager(new GridLayoutManager(mContext,4));

        selectedAdapter = new ChannelAdapter(mContext,selectedList);
        selectedAdapter.setType(1);
        selectedAdapter.setOnItemChoiceListener(new ChannelAdapter.OnItemChoiceListener() {
            @Override
            public void onItemChoice(int position) {
                ChannelBean channelBean = selectedList.get(position);
                selectedList.remove(position);
                unSelectedList.add(0,channelBean);
                selectedAdapter.notifyDataSetChanged();
                unSelectedAdapter.notifyDataSetChanged();
            }
        });
        unSelectedAdapter = new ChannelAdapter(mContext,unSelectedList);
        unSelectedAdapter.setType(0);
        unSelectedAdapter.setOnItemChoiceListener(new ChannelAdapter.OnItemChoiceListener() {
            @Override
            public void onItemChoice(int position) {
                ChannelBean channelBean = unSelectedList.get(position);
                unSelectedList.remove(position);
                selectedList.add(channelBean);
                selectedAdapter.notifyDataSetChanged();
                unSelectedAdapter.notifyDataSetChanged();
            }
        });
        binding.rvSelected.setAdapter(selectedAdapter);
        binding.rvUnselected.setAdapter(unSelectedAdapter);

        initItemTouch();

    }





    private void initItemTouch(){
        ItemTouchHelper.Callback callback = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                int swipeFlags = 0;
                return makeMovementFlags(dragFlags,swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                selectedAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                selectedAdapter.onItemSwipe(viewHolder.getAdapterPosition());
            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return false;
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

        };
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(binding.rvSelected);
    }


    public void showAtLocation(View parent, int gravity, int x, int y) {
        popupWindow.showAtLocation(parent,gravity,x,y);
    }


    public void setChannelList(List<NewsclassifierBean> newsclassifierBeanList){
        for(int i = 0;i<newsclassifierBeanList.size()-3;i++){
            NewsclassifierBean bean = newsclassifierBeanList.get(i);
            ChannelBean channelBean = new ChannelBean();
            channelBean.setName(bean.getName());
            selectedList.add(channelBean);
        }

        for(int i = newsclassifierBeanList.size()-3;i<newsclassifierBeanList.size();i++){
            NewsclassifierBean bean = newsclassifierBeanList.get(i);
            ChannelBean channelBean = new ChannelBean();
            channelBean.setName(bean.getName());
            unSelectedList.add(channelBean);
        }

        selectedAdapter.notifyDataSetChanged();
        unSelectedAdapter.notifyDataSetChanged();
    }

    public void setProductSelecteList(List<ProductSelectBean> productSelectBeanList){
        for(int i = 0;i<productSelectBeanList.size()-3;i++){
            ProductSelectBean bean = productSelectBeanList.get(i);
            ChannelBean channelBean = new ChannelBean();
            channelBean.setName(bean.getName());
            selectedList.add(channelBean);
        }

        for(int i = productSelectBeanList.size()-3;i<productSelectBeanList.size();i++){
            ProductSelectBean bean = productSelectBeanList.get(i);
            ChannelBean channelBean = new ChannelBean();
            channelBean.setName(bean.getName());
            unSelectedList.add(channelBean);
        }

        selectedAdapter.notifyDataSetChanged();
        unSelectedAdapter.notifyDataSetChanged();
    }



}
