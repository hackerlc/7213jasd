package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemAssetlistBinding;
import com.liangke.mvvm.bean.AssetListBean;

import java.util.List;

/**
 * Created by LK on 2017/12/18.
 */

public class AssetListAdapter extends BaseRecyclerViewAdapter {

    private int height;

    public AssetListAdapter(Context context, List<AssetListBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAssetlistBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_assetlist,parent,false);
        return new AssetListHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        AssetListHolder listHolder = (AssetListHolder) holder;

//        listHolder.binding.getRoot().setLayoutParams(params);

    }


    public class AssetListHolder extends RecyclerView.ViewHolder{
        ItemAssetlistBinding binding;
        public AssetListHolder(ItemAssetlistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
