package com.liangke.mvvm.viewmodel;

import android.content.Context;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.ActivitySearchBinding;
import com.liangke.comprehensive.market.SearchActivity;
import com.liangke.http.response.SearchListResponse;
import com.liangke.mvvm.model.SearchListModel;
import com.liangke.mvvm.model.SearchModel;

/**
 * Created by LK on 2017/12/21.
 */

public class SearchViewModel extends BaseViewModel {
    private SearchActivity activity;
    private ActivitySearchBinding binding;
    private SearchModel model;
    private SearchListModel searchListModel;
    public SearchViewModel(SearchActivity activity,ActivitySearchBinding binding) {
        super(activity);
        this.activity = activity;
        this.binding = binding;

        model = new SearchModel(mContext,observer);
        searchListModel = new SearchListModel(mContext,observer);

        init();
    }

    @Override
    public void init() {

        model.init(binding.rvList);

        searchlist();

    }

    @Override
    public void onRxJavaNext(Object value) {
        if(value instanceof SearchListResponse){
            SearchListResponse response = (SearchListResponse) value;
            model.setmList(response.getData());
        }
    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

    public void searchlist(){
        searchListModel.searchlist(SearchListModel.KIND);
    }
}
