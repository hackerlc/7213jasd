package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemAllpositionBinding;
import com.liangke.mvvm.bean.HoldBean;


import java.util.List;

/**
 * Created by LK on 2017/12/26.
 */

public class AllPositionAdapter extends BaseRecyclerViewAdapter<HoldBean> {
    public AllPositionAdapter(Context context, List<HoldBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAllpositionBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_allposition,parent,false);
        return new AllPositionViewHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        AllPositionViewHolder viewHolder = (AllPositionViewHolder) holder;
        viewHolder.binding.setItem(mList.get(position));

    }

    public class AllPositionViewHolder extends RecyclerView.ViewHolder{
        ItemAllpositionBinding binding;
        public AllPositionViewHolder(ItemAllpositionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
