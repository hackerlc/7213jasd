package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.view.View;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.ActivityHomesearchBinding;
import com.liangke.comprehensive.home.HomeSearchActivity;
import com.liangke.http.response.NewsPagesResponse;
import com.liangke.http.response.SearchListResponse;
import com.liangke.mvvm.model.HomeSearchModel;
import com.liangke.mvvm.model.NewsPagesModel;
import com.liangke.mvvm.model.SearchListModel;
import com.liangke.mvvm.rxbing.HomeSearchBing;

/**
 * Created by LK on 2017/12/22.
 */

public class HomeSearchViewModel extends BaseViewModel {
    private HomeSearchActivity activity;
    private ActivityHomesearchBinding binding;
    private HomeSearchModel model;
    private SearchListModel searchListModel;
    private NewsPagesModel newsPagesModel;
    public HomeSearchViewModel(HomeSearchActivity activity, ActivityHomesearchBinding binding) {
        super(activity);
        this.activity = activity;
        this.binding = binding;

        model = new HomeSearchModel(mContext,observer);
        searchListModel = new SearchListModel(mContext,observer);
        newsPagesModel = new NewsPagesModel(mContext,observer);

        HomeSearchBing bing = new HomeSearchBing(mContext,this,binding);

        init();

    }

    @Override
    public void init() {

        searchlist();

        model.init(binding.rvList);

    }

    @Override
    public void onRxJavaNext(Object value) {

        if(value instanceof SearchListResponse){
            SearchListResponse response = (SearchListResponse) value;
            model.setmList(response.getData());
        }else if(value instanceof NewsPagesResponse){
            NewsPagesResponse response = (NewsPagesResponse) value;
            binding.tvHot.setVisibility(View.GONE);
            model.setNewsPagesBeanList(response.getData().getRows());
        }

    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

    public void searchlist(){
        searchListModel.searchlist(SearchListModel.INFORMATION);
    }

    public void newsPages(String keyWord){
        newsPagesModel.newsPages("",keyWord);
    }

}
