package com.liangke.mvvm.model;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liangke.adapter.HomeSearchAdapter;
import com.liangke.adapter.InformationAdapter;
import com.liangke.base.BaseModel;
import com.liangke.comprehensive.R;
import com.liangke.mvvm.bean.HomeSearchBean;
import com.liangke.mvvm.bean.NewsPagesBean;
import com.liangke.mvvm.bean.SearchBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/22.
 */

public class HomeSearchModel extends BaseModel {

    private List<SearchBean> mList = new ArrayList<>();
    private List<NewsPagesBean> newsPagesBeanList = new ArrayList<>();
    private HomeSearchAdapter mAdapter;

    private RecyclerView recyclerView;

    public HomeSearchModel(Context context, Observer observer) {
        super(context, observer);

    }

    public void init(RecyclerView recyclerView){
        this.recyclerView =recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mAdapter = new HomeSearchAdapter(mContext,mList);
        recyclerView.setAdapter(mAdapter);

    }

    public List<SearchBean> getmList() {
        return mList;
    }

    public void setmList(List<SearchBean> mList) {
        for(int i = 0;i<5;i++){
            this.mList.add(mList.get(i));
        }
        mAdapter.notifyDataSetChanged();
    }

    public List<NewsPagesBean> getNewsPagesBeanList() {
        return newsPagesBeanList;
    }

    public void setNewsPagesBeanList(List<NewsPagesBean> newsPagesBeanList) {
        this.newsPagesBeanList.addAll(newsPagesBeanList);

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(mContext, R.drawable.devider_item));
        recyclerView.addItemDecoration(dividerItemDecoration);
        InformationAdapter informationAdapter = new InformationAdapter(mContext,newsPagesBeanList);
        recyclerView.setAdapter(informationAdapter);

    }
}
