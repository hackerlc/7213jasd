package com.liangke.mvvm.model;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liangke.adapter.AllPositionAdapter;
import com.liangke.base.BaseModel;
import com.liangke.comprehensive.R;
import com.liangke.mvvm.bean.AllPositionBean;
import com.liangke.mvvm.bean.HoldBean;
import com.liangke.tcp.packet.QuoteRealPushBody;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/26.
 */

public class AllPositionModel extends BaseModel {

    private List<HoldBean> mList = new ArrayList<>();
    private AllPositionAdapter mAdapter;
    public AllPositionModel(Context context, Observer observer) {
        super(context, observer);

    }

    public void init(RecyclerView recyclerView){

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(mContext, R.drawable.devider_item));
        recyclerView.addItemDecoration(dividerItemDecoration);

        mAdapter = new AllPositionAdapter(mContext,mList);

        recyclerView.setAdapter(mAdapter);


    }


    public List<HoldBean> getmList() {
        return mList;
    }

    public void setmList(List<HoldBean> mList) {
        if(mList==null){
            return;
        }
        this.mList.addAll(mList);
        mAdapter.notifyDataSetChanged();
    }

    public void update(QuoteRealPushBody body){
        for(HoldBean bean:mList){
            if(body.getCommodityNo().equals(bean.getSymbol())){
                bean.setBid(body.getBid());
            }
        }
    }

}
