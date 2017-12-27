package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemHomesearchBinding;
import com.liangke.mvvm.bean.SearchBean;
import com.liangke.mvvm.viewmodel.HomeSearchViewModel;

import java.util.List;

/**
 * Created by LK on 2017/12/22.
 */

public class HomeSearchAdapter extends BaseRecyclerViewAdapter<SearchBean> {

    private int viewType = 0;

    public HomeSearchAdapter(Context context, List<SearchBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemHomesearchBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_homesearch,parent,false);
        return new HomeSearhViewHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        HomeSearhViewHolder viewHolder = (HomeSearhViewHolder) holder;
        viewHolder.binding.setItem(mList.get(position));

    }



    public class HomeSearhViewHolder extends RecyclerView.ViewHolder{
        ItemHomesearchBinding binding;
        public HomeSearhViewHolder(ItemHomesearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
