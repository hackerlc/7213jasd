package com.liangke.mvvm.model;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liangke.adapter.SearchAdapter;
import com.liangke.base.BaseModel;
import com.liangke.mvvm.bean.SearchBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/21.
 */

public class SearchModel extends BaseModel {
    private List<SearchBean> mList = new ArrayList<>();
    private SearchAdapter mAdapter;
    public SearchModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void init(RecyclerView recyclerView){

        recyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
        mAdapter = new SearchAdapter(mContext,mList);
        recyclerView.setAdapter(mAdapter);

    }

    public List<SearchBean> getmList() {
        return mList;
    }

    public void setmList(List<SearchBean> mList) {
        this.mList.addAll(mList);
        mAdapter.notifyDataSetChanged();
    }
}
