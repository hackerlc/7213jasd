package com.liangke.mvvm.viewmodel;

import android.content.Context;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.ActivityProductBinding;
import com.liangke.comprehensive.market.ProductListActivity;
import com.liangke.http.response.CommodityPagesResponse;
import com.liangke.mvvm.model.CommodityPagesModel;
import com.liangke.mvvm.model.ProductListModel;

/**
 * Created by LK on 2017/12/27.
 */

public class ProductListViewModel extends BaseViewModel {
    private ProductListActivity activity;
    private ActivityProductBinding binding;
    private ProductListModel model;
    private CommodityPagesModel pagesModel;
    private String productId = "";
    public ProductListViewModel(ProductListActivity activity, ActivityProductBinding binding) {
        super(activity);
        this.activity = activity;
        this.binding = binding;

        model = new ProductListModel(mContext,observer);
        pagesModel = new CommodityPagesModel(mContext,observer);

        init();

    }

    @Override
    public void init() {

        productId = activity.getIntent().getStringExtra("productId");

        model.init(binding.rvList);
    }

    @Override
    public void onRxJavaNext(Object value) {

        if(value instanceof CommodityPagesResponse){
            CommodityPagesResponse response = (CommodityPagesResponse) value;

        }

    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

    public void commodityPages(){
        pagesModel.commodityPages(productId);
    }

}
