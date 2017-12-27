package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemFreechoiceBinding;
import com.liangke.comprehensive.databinding.ItemOtherchoiceBinding;
import com.liangke.comprehensive.market.ProductListActivity;
import com.liangke.comprehensive.market.SingleMarketActivity;
import com.liangke.mvvm.bean.FreeChoiceBean;
import com.liangke.mvvm.bean.OtherChoiceBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/14.
 */

public class OtherChoiceAdapter extends BaseRecyclerViewAdapter<OtherChoiceBean> {

    private List<String> positionList = new ArrayList<>();

    public OtherChoiceAdapter(Context context, List<OtherChoiceBean> list) {
        super(context, list);
    }

    public OtherChoiceAdapter(Fragment fragment, List<OtherChoiceBean> list) {
        super(fragment, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemOtherchoiceBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_otherchoice,parent,false);
        return new OtherChoiceHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        OtherChoiceHolder choiceHolder = (OtherChoiceHolder) holder;
        choiceHolder.binding.setItem(mList.get(position));

        String tempP = position+"";
        if(positionList.contains(tempP)){
            choiceHolder.binding.rvList.setVisibility(View.GONE);
            choiceHolder.binding.ivFold.setImageResource(R.mipmap.icon_arrow_right_blue);
        }else{
            choiceHolder.binding.rvList.setVisibility(View.VISIBLE);
            choiceHolder.binding.ivFold.setImageResource(R.mipmap.icon_arrow_down_blue);
        }

        choiceHolder.binding.llFold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p = position+"";
                if(positionList.contains(p)){
                    positionList.remove(p);
                }else{
                    positionList.add(p);
                }
                notifyDataSetChanged();
            }
        });


        RxView.clicks(choiceHolder.binding.llMore).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                Bundle bundle = new Bundle();
                bundle.putString("productId",mList.get(position).getExchangeCode());
                mStartActivity(ProductListActivity.class,bundle);
            }
        });


        choiceHolder.binding.rvList.setLayoutManager(new LinearLayoutManager(mContext));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(mContext,R.drawable.devider_item));
        choiceHolder.binding.rvList.addItemDecoration(dividerItemDecoration);
        ProductAdapter productAdapter = new ProductAdapter(mContext,mList.get(position).getCommodityList());
        choiceHolder.binding.rvList.setAdapter(productAdapter);

    }

    public class OtherChoiceHolder extends RecyclerView.ViewHolder{

        ItemOtherchoiceBinding binding;

        public OtherChoiceHolder(ItemOtherchoiceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
