package com.liangke.mvvm.model;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.liangke.adapter.OtherChoiceAdapter;
import com.liangke.base.BaseModel;
import com.liangke.comprehensive.R;
import com.liangke.mvvm.bean.OtherChoiceBean;
import com.liangke.mvvm.bean.ProductBean;
import com.liangke.tcp.packet.QuoteRealPushBody;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/21.
 */

public class OtherChoiceModel extends BaseModel {
    private final String TAG = OtherChoiceModel.class.getSimpleName();

    private List<OtherChoiceBean> mList = new ArrayList<>();

    private OtherChoiceAdapter mAdapter;

    public OtherChoiceModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void init(RecyclerView recyclerView){

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(mContext, R.drawable.devider_item_02));
        recyclerView.addItemDecoration(dividerItemDecoration);

        mAdapter = new OtherChoiceAdapter(mContext,mList);
        recyclerView.setAdapter(mAdapter);


    }

    public List<OtherChoiceBean> getmList() {
        return mList;
    }

    public void setmList(List<OtherChoiceBean> mList) {
        this.mList.addAll(mList);
        mAdapter.notifyDataSetChanged();
    }


    public void update(QuoteRealPushBody body){
        for(OtherChoiceBean otherChoiceBean:mList){
            for(ProductBean bean:otherChoiceBean.getCommodityList()){
                if(body.getCommodityNo().equals(bean.getCommodityNo())){
                    bean.setBid(body.getBid());
                    if(body.getSettle()==null||"null".equals(body.getSettle())){
                        return;
                    }

                    float settle = Float.parseFloat(body.getSettle());
                    float bid = Float.parseFloat(body.getBid());

                    float change =  bid-settle;//涨跌额
                    bean.setChange(change+"");
                    float chg = (bid-settle)/settle;//涨跌幅
                    bean.setChg(chg+"");
                    bean.setTime(body.getTime()+"");
                }
            }
        }
    }
}

