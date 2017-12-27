package com.liangke.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemOtherchoiceBinding;
import com.liangke.comprehensive.databinding.ItemProductBinding;
import com.liangke.comprehensive.market.SingleMarketActivity;
import com.liangke.mvvm.bean.OtherChoiceBean;
import com.liangke.mvvm.bean.ProductBean;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/14.
 */

public class ProductAdapter extends BaseRecyclerViewAdapter<ProductBean> {

    public ProductAdapter(Context context, List<ProductBean> list) {
        super(context, list);
    }

    public ProductAdapter(Fragment fragment, List<ProductBean> list) {
        super(fragment, list);
    }

    @Override
    public RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemProductBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_product,parent,false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void MY_onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ProductViewHolder choiceHolder = (ProductViewHolder) holder;
        choiceHolder.binding.setItem(mList.get(position));


        RxView.clicks(choiceHolder.itemView).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                Bundle bundle = new Bundle();
                bundle.putString("commodityCode",mList.get(position).getCommodityNo());
                bundle.putString("productId",mList.get(position).getProductId());
                mStartActivity(SingleMarketActivity.class,bundle);
            }
        });


    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        ItemProductBinding binding;

        public ProductViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
