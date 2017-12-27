package com.liangke.mvvm.viewmodel;


import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.community.CommunityFragment;
import com.liangke.comprehensive.databinding.FragmentCommunityBinding;
import com.liangke.http.response.NewsclassifierResponse;
import com.liangke.http.response.TopicsResponse;
import com.liangke.mvvm.bean.TopicBean;
import com.liangke.mvvm.model.CommunityModel;
import com.liangke.mvvm.model.NewsclassifierModel;
import com.liangke.mvvm.model.TopicsPagesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/26.
 */

public class CommunityViewModel extends BaseViewModel {
    private CommunityFragment fragment;
    private FragmentCommunityBinding binding;
    private CommunityModel model;
    private TopicsPagesModel topicsModel;
    private int page = 1;
    private List<TopicBean> data = new ArrayList<>();
    private NewsclassifierModel newsclassifierModel;
    public CommunityViewModel(CommunityFragment fragment,FragmentCommunityBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;
        model = new CommunityModel(mContext,observer);
        topicsModel = new TopicsPagesModel(mContext,observer);
        newsclassifierModel = new NewsclassifierModel(mContext,observer);
        init();

    }

    @Override
    public void init() {
        model.init(binding.rvList,data);
        newsclassifierModel.newsclassifier();
        topicsModel.fetchTopics(true,page);
    }

    @Override
    public void onRxJavaNext(Object value) {
        if (value instanceof TopicsResponse) {
            TopicsResponse topicsResponse = (TopicsResponse) value;
            if(topicsResponse.getData() == null){
                return;
            }
            if(page == 1){
                data.clear();
            }
            data.addAll(topicsResponse.getData());
            model.refresh();
        }else if(value instanceof NewsclassifierResponse){
            NewsclassifierResponse response = (NewsclassifierResponse) value;
            if(response.getData()==null){
                return;
            }
            model.initClassify(response.getData(),binding.hllList);
        }
    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }
}
