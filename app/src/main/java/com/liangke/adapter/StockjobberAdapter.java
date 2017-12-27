package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemStockjobberBinding;
import com.liangke.mvvm.bean.StockjobberBean;
import com.liangke.popupwindow.StockjobberPopupWindow;

import java.util.List;

/**
 * Created by LK on 2017/12/26.
 */

public class StockjobberAdapter extends BaseRecyclerViewAdapter<StockjobberBean> {

    private StockjobberPopupWindow.OnItemClickListener onItemClickListener;

    public StockjobberAdapter(Context context, List<StockjobberBean> list) {
        super(context, list);

    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemStockjobberBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_stockjobber,parent,false);
        return new StockjobberViewHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        StockjobberViewHolder viewHolder = (StockjobberViewHolder) holder;
        viewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick(mList.get(position));
                }
            }
        });
    }

    public class StockjobberViewHolder extends RecyclerView.ViewHolder{
        ItemStockjobberBinding binding;
        public StockjobberViewHolder(ItemStockjobberBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public StockjobberPopupWindow.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(StockjobberPopupWindow.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
