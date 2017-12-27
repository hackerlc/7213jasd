package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.Gravity;

import com.liangke.base.BaseModel;
import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.FragmentPositionBinding;
import com.liangke.comprehensive.position.AllPositionFragment;
import com.liangke.comprehensive.position.PositionFragment;
import com.liangke.mvvm.bean.StockjobberBean;
import com.liangke.mvvm.model.HoldModel;
import com.liangke.mvvm.rxbing.PositionBing;
import com.liangke.popupwindow.StockjobberPopupWindow;
import com.liangke.utils.FragmentSwitchUtils;
import com.liangke.widget.TabContent;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/25.
 */

public class PositionViewModel extends BaseViewModel {
    private PositionFragment fragment;
    private FragmentPositionBinding binding;

    public PositionViewModel(PositionFragment fragment,FragmentPositionBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;

        PositionBing bing = new PositionBing(mContext,this,binding);

        init();

    }

    @Override
    public void init() {


        List<TabContent> tabContentList = new ArrayList<>();
        String[] tab = {"全部持仓","委托单","成交记录"};
        for(int i = 0;i<tab.length;i++){
            TabContent tabContent = new TabContent();
            tabContent.tab_txt = tab[i];
            tabContent.tab_txt_size = 16;
            tabContent.tab_txtColor_selected = R.color.black;
            tabContent.tab_txtColor_unslected = R.color.black_01;
            tabContentList.add(tabContent);
        }
        binding.tllTab.getTabManager().setmList(tabContentList);


        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new AllPositionFragment());
        FragmentSwitchUtils switchUtils = new FragmentSwitchUtils(fragmentList,fragment.getChildFragmentManager(),binding.flFragment.getId());







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


    public void switchAccount(){
        StockjobberPopupWindow popupWindow = new StockjobberPopupWindow(mContext);
        popupWindow.setOnItemClickListener(new StockjobberPopupWindow.OnItemClickListener() {
            @Override
            public void onItemClick(StockjobberBean bean) {
                binding.tvAccount.setText(bean.getTest());
            }
        });
        popupWindow.showAtLocation(binding.llMain, Gravity.CENTER,0,0);

    }

}
