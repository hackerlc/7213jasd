package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemInformationBinding;
import com.liangke.mvvm.bean.NewsPagesBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by LK on 2017/12/18.
 */

public class InformationAdapter extends BaseRecyclerViewAdapter<NewsPagesBean> {

    private final String TAG = InformationHolder.class.getSimpleName();

    public InformationAdapter(Context context, List<NewsPagesBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemInformationBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_information,parent,false);

        return new InformationHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        InformationHolder informationHolder = (InformationHolder) holder;
        informationHolder.binding.setItem(mList.get(position));

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String time = format.format(new Date(mList.get(position).getIssueTime()));
        informationHolder.binding.tvTime.setText(time);

    }

    public class InformationHolder extends RecyclerView.ViewHolder{
        ItemInformationBinding binding;
        public InformationHolder(ItemInformationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}
