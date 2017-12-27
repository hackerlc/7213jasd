package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.FragmentMineBinding;
import com.liangke.comprehensive.mine.AlreadyLoginFragment;
import com.liangke.comprehensive.mine.MineFragment;
import com.liangke.comprehensive.mine.UnLoginFragment;
import com.liangke.data.Preferences;
import com.liangke.utils.FragmentSwitchUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/13.
 */

public class MineViewModel extends BaseViewModel {
    private MineFragment fragment;
    private FragmentMineBinding binding;
    private FragmentSwitchUtils switchUtils;
    public MineViewModel(MineFragment fragment, FragmentMineBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;
        init();
    }

    @Override
    public void init() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new UnLoginFragment());
        fragmentList.add(new AlreadyLoginFragment());
        switchUtils = new FragmentSwitchUtils(fragmentList,fragment.getChildFragmentManager(),binding.flFragment.getId());
        if(Preferences.getInstance(mContext).getToken()!=null){
            switchUtils.swtichFragment(1);
        }
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
