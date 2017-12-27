package com.liangke.mvvm.model;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.liangke.adapter.AssetListAdapter;
import com.liangke.base.BaseModel;
import com.liangke.comprehensive.R;
import com.liangke.mvvm.bean.AssetListBean;
import com.liangke.utils.GridDividerItemDecoration;
import com.liangke.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/18.
 */

public class AssetListModel extends BaseModel {

    private final String TAG = AssetListModel.class.getSimpleName();

    private List<AssetListBean> mList = new ArrayList<>();
    private AssetListAdapter mAdapter;

    public AssetListModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void init(RecyclerView recyclerView){

        int height = recyclerView.getHeight();

        recyclerView.setLayoutManager(new GridLayoutManager(mContext,2));

        for(int i = 0;i<8;i++){
            mList.add(new AssetListBean());
        }

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
//        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(mContext, R.drawable.devider_item));
//        recyclerView.addItemDecoration(dividerItemDecoration);

        GridDividerItemDecoration gridDividerItemDecoration = new GridDividerItemDecoration(mContext,1,ContextCompat.getColor(mContext,R.color.gray_03));
        recyclerView.addItemDecoration(gridDividerItemDecoration);


        mAdapter = new AssetListAdapter(mContext,mList);

        recyclerView.setAdapter(mAdapter);

    }


    public List<AssetListBean> getmList() {
        return mList;
    }

    public void setmList(List<AssetListBean> mList) {
        this.mList.addAll(mList);
        mAdapter.notifyDataSetChanged();
    }

    public void setItemHeight(int height){
        int h = (height- Utils.getScaleByDensity(mContext,50))/4;
        mAdapter.setHeight(h);
    }

}
