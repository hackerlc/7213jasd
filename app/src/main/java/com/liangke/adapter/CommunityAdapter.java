package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemCommunityBinding;

import java.util.List;

/**
 * Created by LK on 2017/12/26.
 */

public class CommunityAdapter extends BaseRecyclerViewAdapter {
    public CommunityAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCommunityBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_community,parent,false);
        return new CommunityViewHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public class CommunityViewHolder extends RecyclerView.ViewHolder{
        ItemCommunityBinding binding;
        public CommunityViewHolder(ItemCommunityBinding binding) {
            super(binding.getRoot());
        }
    }

}
