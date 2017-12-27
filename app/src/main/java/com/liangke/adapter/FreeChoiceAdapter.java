package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemFreechoiceBinding;
import com.liangke.comprehensive.market.SingleMarketActivity;
import com.liangke.mvvm.bean.FreeChoiceBean;
import com.liangke.mvvm.bean.QueryFavoriteCommodityBean;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/14.
 */

public class FreeChoiceAdapter extends BaseRecyclerViewAdapter<QueryFavoriteCommodityBean> {

    public FreeChoiceAdapter(Context context, List<QueryFavoriteCommodityBean> list) {
        super(context, list);
    }

    public FreeChoiceAdapter(Fragment fragment, List<QueryFavoriteCommodityBean> list) {
        super(fragment, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemFreechoiceBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_freechoice,parent,false);
        return new FreeChoiceHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        FreeChoiceHolder freeChoiceHolder = (FreeChoiceHolder) holder;
        freeChoiceHolder.binding.setItem(mList.get(position));
        freeChoiceHolder.binding.setImgUrl(R.mipmap.icon_arrow_red);



        RxView.clicks(freeChoiceHolder.itemView).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                mStartActivity(SingleMarketActivity.class);
            }
        });


    }

    public class FreeChoiceHolder extends RecyclerView.ViewHolder{

        ItemFreechoiceBinding binding;

        public FreeChoiceHolder(ItemFreechoiceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
