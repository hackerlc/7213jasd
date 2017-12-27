package com.liangke.mvvm.viewmodel;

import android.support.v4.app.Fragment;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.community.CommunityFragment;
import com.liangke.comprehensive.databinding.ActivityMainBinding;
import com.liangke.comprehensive.home.HomeFragment;
import com.liangke.comprehensive.market.MarketFragment;
import com.liangke.comprehensive.mine.MineFragment;
import com.liangke.comprehensive.position.PositionFragment;
import com.liangke.comprehensive.main.MainActivity;
import com.liangke.constants.TabConstants;
import com.liangke.utils.FragmentSwitchUtils;
import com.liangke.widget.TabContent;
import com.liangke.widget.TabManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/12.
 */

public class MainViewModel extends BaseViewModel{

    private ActivityMainBinding binding;
    private MainActivity activity;
    private  FragmentSwitchUtils switchUtils;
    public MainViewModel(MainActivity context,ActivityMainBinding binding) {
        super(context);
        this.binding = binding;
        activity = context;
    }


    @Override
    public void init() {

         List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new MarketFragment());
        fragmentList.add(new PositionFragment());
        fragmentList.add(new CommunityFragment());
        fragmentList.add(new MineFragment());
        switchUtils = new FragmentSwitchUtils(fragmentList,activity.getSupportFragmentManager(),binding.flFragment.getId());



        TabManager manager = binding.tllTab.getTabManager();
        manager.setmList(TabConstants.tabContentList);
        manager.setOnSelectedPositionListener(new TabManager.OnSelectedPositionListener() {
            @Override
            public void onSelectedPositionListener(int position) {
                switchUtils.swtichFragment(position);
            }
        });
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
