package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemSearchBinding;
import com.liangke.mvvm.bean.SearchBean;
import com.liangke.mvvm.viewmodel.SearchViewModel;

import java.util.List;

/**
 * Created by LK on 2017/12/21.
 */

public class SearchAdapter extends BaseRecyclerViewAdapter<SearchBean> {
    public SearchAdapter(Fragment fragment, List<SearchBean> list) {
        super(fragment, list);

    }

    public SearchAdapter(Context context,List<SearchBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSearchBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_search,parent,false);
        return new SearchViewHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        SearchViewHolder viewHolder = (SearchViewHolder) holder;
        viewHolder.binding.setItem(mList.get(position));


    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{
        ItemSearchBinding binding;
        public SearchViewHolder(ItemSearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
