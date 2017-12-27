package com.liangke.mvvm.model;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liangke.adapter.CommunityAdapter;
import com.liangke.base.BaseModel;
import com.liangke.comprehensive.R;
import com.liangke.mvvm.bean.CommunityBean;
import com.liangke.mvvm.bean.NewsclassifierBean;
import com.liangke.mvvm.bean.TopicBean;
import com.liangke.widget.HorizontalListManager;
import com.liangke.widget.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/26.
 */

public class CommunityModel extends BaseModel {

    private List<TopicBean> mList = new ArrayList<>();
    private CommunityAdapter mAdapter;
    public CommunityModel(Context context, Observer observer) {
        super(context, observer);

    }

    public void init(RecyclerView recyclerView,List<TopicBean> data){
//        mList.clear();
//        mList.addAll(data);
//        for(int i = 0;i<10;i++){
//            mList.add(new TopicBean());
//        }

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new CommunityAdapter(mContext,data);
        recyclerView.setAdapter(mAdapter);
    }

    public void refresh(){
        mAdapter.notifyDataSetChanged();
    }

    public void initClassify(final List<NewsclassifierBean> newsclassifierBeen, HorizontalListView horizontalListView){

        HorizontalListManager manager = horizontalListView.getManager();
        manager.setTxtColor(R.color.black);
        manager.setOnBindTextListener(new HorizontalListManager.OnBindTextListener() {
            @Override
            public String onBindText(int position) {
                return newsclassifierBeen.get(position).getName();
            }

            @Override
            public int getSize() {
                return newsclassifierBeen.size();
            }
        });
        manager.notifyDataSetChanged();

    }

}
