package com.liangke.mvvm.viewmodel;

import android.content.Context;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.FragmentHomeBinding;
import com.liangke.comprehensive.home.HomeFragment;
import com.liangke.http.response.BannerSelectResponse;
import com.liangke.http.response.NewsPagesResponse;
import com.liangke.http.response.NewsclassifierResponse;
import com.liangke.mvvm.bean.ChannelBean;
import com.liangke.mvvm.bean.NewsclassifierBean;
import com.liangke.mvvm.model.BannerSelectModel;
import com.liangke.mvvm.model.HomeModel;
import com.liangke.mvvm.model.NewsPagesModel;
import com.liangke.mvvm.model.NewsclassifierModel;
import com.liangke.mvvm.model.SubjectModel;
import com.liangke.mvvm.model.SubjectPagesModel;
import com.liangke.mvvm.rxbing.HomeBing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/18.
 */

public class HomeViewModel extends BaseViewModel {
    private HomeFragment fragment;
    private FragmentHomeBinding binding;
    private HomeModel model;
    private BannerSelectModel bannerSelectModel;
    private NewsclassifierModel newsclassifierModel;
    private NewsPagesModel newsPagesModel;

    private List<NewsclassifierBean> newsclassifierBeanList = new ArrayList<>();

    public HomeViewModel(HomeFragment fragment, FragmentHomeBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;

        model = new HomeModel(mContext,observer);

        bannerSelectModel = new BannerSelectModel(mContext,observer);
        newsclassifierModel = new NewsclassifierModel(mContext,observer);
        newsPagesModel = new NewsPagesModel(mContext,observer);

        HomeBing bing = new HomeBing(mContext,this,binding);

        init();

    }

    @Override
    public void init() {

        newsclassifier();

        model.init(binding.rvList);

        bannerSelect();

    }

    @Override
    public void onRxJavaNext(Object value) {

        if(value instanceof BannerSelectResponse){
            BannerSelectResponse response = (BannerSelectResponse) value;
            model.setLocalImages(response.getData());
            model.initBanner(binding.cbBanner);
        }else if(value instanceof NewsclassifierResponse){
            NewsclassifierResponse response = (NewsclassifierResponse) value;
            if(response.getData()==null){
                return;
            }
            newsclassifierBeanList.addAll(response.getData());
            model.initClassify(response.getData(),binding.hllList);
            newsPages(response.getData().get(0).getId());
        }else if(value instanceof NewsPagesResponse){
            NewsPagesResponse response = (NewsPagesResponse) value;
            if(response.getData()==null){
                return;
            }
            model.setmList(response.getData().getRows());
        }

    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

    public void bannerSelect(){
        bannerSelectModel.bannerSelect();
    }


    public void newsclassifier(){
        newsclassifierModel.newsclassifier();
    }

    public void newsPages(String classifierId){
        newsPagesModel.newsPages(classifierId,"");
    }

    public List<NewsclassifierBean> getNewsclassifierBeanList() {
        return newsclassifierBeanList;
    }

    public void setNewsclassifierBeanList(List<NewsclassifierBean> newsclassifierBeanList) {
        this.newsclassifierBeanList = newsclassifierBeanList;
    }
}
