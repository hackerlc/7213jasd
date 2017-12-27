package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityActionBinding;
import com.liangke.comprehensive.position.ActionActivity;
import com.liangke.comprehensive.position.BuyFragment;
import com.liangke.comprehensive.position.QueryFragment;
import com.liangke.utils.FragmentSwitchUtils;
import com.liangke.widget.TabContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/26.
 */

public class ActionViewModel extends BaseViewModel {
    private ActionActivity activity;
    private ActivityActionBinding binding;
    public ActionViewModel(ActionActivity activity,ActivityActionBinding binding) {
        super(activity);
        this.activity = activity;
        this.binding = binding;

        init();

    }

    @Override
    public void init() {

        String[] tab = {"买入","卖出","查询","入金出金"};
        List<TabContent> tabContentList = new ArrayList<>();
        for(int i = 0;i<tab.length;i++){
            TabContent tabContent = new TabContent();
            tabContent.tab_txt = tab[i];
            tabContent.tab_txtColor_unslected = R.color.black_01;
            tabContent.tab_txtColor_selected = R.color.black;
            tabContentList.add(tabContent);
        }
        binding.tllTab.getTabManager().setmList(tabContentList);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new BuyFragment());
        fragmentList.add(new QueryFragment());
        FragmentSwitchUtils utils = new FragmentSwitchUtils(fragmentList,activity.getSupportFragmentManager(),binding.flFragment.getId());

    }

    @Override
    public void onRxJavaNext(Object value) {

    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }
}
