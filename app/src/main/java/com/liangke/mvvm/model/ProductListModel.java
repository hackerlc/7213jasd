package com.liangke.mvvm.model;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import com.liangke.adapter.ProductAdapter;
import com.liangke.base.BaseModel;
import com.liangke.comprehensive.R;
import com.liangke.mvvm.bean.ProductBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/27.
 */

public class ProductListModel extends BaseModel {

    private List<ProductBean> mList = new ArrayList<>();
    private ProductAdapter mAdapter;

    public ProductListModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void init(RecyclerView recyclerView){

        for(int i = 0;i<10;i++){
            mList.add(new ProductBean());
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(mContext, R.drawable.devider_item));
        recyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new ProductAdapter(mContext,mList);
        recyclerView.setAdapter(mAdapter);

    }

}
