package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.ViewGroup;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemChannelBinding;
import com.liangke.mvvm.bean.ChannelBean;

import java.util.Collections;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/18.
 */

public class ChannelAdapter extends BaseRecyclerViewAdapter<ChannelBean>{

    private int type;//1是已选择，0是未选择

    private OnItemChoiceListener onItemChoiceListener;

    public ChannelAdapter(Context context, List<ChannelBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemChannelBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_channel,parent,false);
        return new ChannelHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ChannelHolder channelHolder = (ChannelHolder) holder;
        channelHolder.binding.setItem(mList.get(position));

        if(type==1){
            channelHolder.binding.ivChoice.setImageResource(R.mipmap.icon_decrease);
        } else if (type==0) {
            channelHolder.binding.ivChoice.setImageResource(R.mipmap.icon_add_02);
        }
        RxView.clicks(channelHolder.binding.ivChoice).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                if(onItemChoiceListener!=null){
                    onItemChoiceListener.onItemChoice(position);
                }
            }
        });

    }







    public class ChannelHolder extends RecyclerView.ViewHolder{
        ItemChannelBinding binding;
        public ChannelHolder(ItemChannelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void onItemMove(int fromPosition, int toPosition){

        /**
         * 在这里进行给原数组数据的移动
         */
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mList, i, i - 1);
            }
        }
        /**
         * 通知数据移动
         */
        notifyItemMoved(fromPosition, toPosition);


    }
    public void onItemSwipe(int position){

        /**
         * 原数据移除数据
         */
        mList.remove(position);
        /**
         * 通知移除
         */
        notifyItemRemoved(position);

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public interface OnItemChoiceListener{
        public void onItemChoice(int position);
    }

    public OnItemChoiceListener getOnItemChoiceListener() {
        return onItemChoiceListener;
    }

    public void setOnItemChoiceListener(OnItemChoiceListener onItemChoiceListener) {
        this.onItemChoiceListener = onItemChoiceListener;
    }
}
