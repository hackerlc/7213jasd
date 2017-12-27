package com.liangke.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.liangke.comprehensive.R;

import java.util.List;

/**
 * Created by LK on 8月16日 0016.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter {
    public final int NormalType = 1010;
    public final int LoadingType = 1011;
    public List<T> mList;
    public Context mContext;
    public LayoutInflater inflater;
    private boolean isUpLoading = false;
    private boolean isUpLoadingFinsh = false;
    public Fragment fragment;

    public BaseRecyclerViewAdapter(Fragment fragment, List<T> list) {
        this(fragment.getActivity(),list);
        this.fragment = fragment;
    }

    public BaseRecyclerViewAdapter(Context context, List<T> list) {
        mContext = context;
        mList = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == NormalType) {
            return MY_onCreateViewHolder(parent, viewType);
        } else {
            return new LoadingHolder(inflater.inflate(R.layout.item_loading,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==NormalType){
            MY_onBindViewHolder(holder, position);
        }else{
            if(isUpLoadingFinsh){
                LoadingHolder loadingHolder = (LoadingHolder) holder;
                loadingHolder.pb_loading.setVisibility(View.GONE);
                loadingHolder.tv_loading.setText("已加载全部数据");
            }else{
                LoadingHolder loadingHolder = (LoadingHolder) holder;
                loadingHolder.pb_loading.setVisibility(View.VISIBLE);
                loadingHolder.tv_loading.setText("正在加载数据...");
            }
        }

    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (isUpLoading) {
            count = mList.size() + 1;
        } else {
            count = mList.size();
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int type = NormalType;
        if (isUpLoading) {
            if (position == mList.size()) {
                return LoadingType;
            } else {
                return NormalType;
            }
        }
        return type;
    }

    public abstract RecyclerView.ViewHolder MY_onCreateViewHolder(ViewGroup parent, int viewType);

    public abstract void MY_onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public void mStartActivity(Class<?> mClass) {
        Intent intent = new Intent(mContext, mClass);
        mContext.startActivity(intent);
    }

    public void mStartActivity(Class<?> mClass, Bundle bundle) {
        Intent intent = new Intent(mContext, mClass);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public boolean isUpLoading() {
        return isUpLoading;
    }

    public void setUpLoading(boolean upLoading) {
        isUpLoading = upLoading;
    }


    public class LoadingHolder extends RecyclerView.ViewHolder {
        ProgressBar pb_loading;
        TextView tv_loading;

        public LoadingHolder(View itemView) {
            super(itemView);
            pb_loading = (ProgressBar) itemView.findViewById(R.id.pb_loading);
            tv_loading = (TextView) itemView.findViewById(R.id.tv_loading);
        }
    }

    public boolean isUpLoadingFinsh() {
        return isUpLoadingFinsh;
    }

    public void setUpLoadingFinsh(boolean upLoadingFinsh) {
        isUpLoadingFinsh = upLoadingFinsh;
    }
}
