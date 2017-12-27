package com.liangke.mvvm.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.liangke.adapter.ChoiceAssetAdapter;
import com.liangke.base.BaseModel;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.market.FreeChoiceFragment;
import com.liangke.comprehensive.market.OtherChoiceFragment;
import com.liangke.mvvm.bean.NewsclassifierBean;
import com.liangke.mvvm.bean.ProductSelectBean;
import com.liangke.utils.FragmentSwitchUtils;
import com.liangke.utils.Utils;
import com.liangke.widget.HorizontalListManager;
import com.liangke.widget.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/22.
 */

public class MarketModel extends BaseModel {

    private ViewPager viewPager;
    private FragmentSwitchUtils utils;
    public MarketModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void init(){

    }

    public void initClassify(final List<ProductSelectBean> newsclassifierBeen, HorizontalListView horizontalListView){

        final HorizontalListManager manager = horizontalListView.getManager();
        manager.setTxtSelectedColor(R.color.black_01);
        manager.setTxtUnSelectedColor(R.color.gray_01);
        manager.setSelectedPosition(0);
        manager.setOnBindTextListener(new HorizontalListManager.OnBindTextListener() {
            @Override
            public String onBindText(int position) {
                return newsclassifierBeen.get(position).getName();
            }

            @Override
            public int getSize() {
                return newsclassifierBeen.size();
            }
        });
        manager.setOnItemClickListener(new HorizontalListManager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                viewPager.setCurrentItem(position);
                utils.swtichFragment(position);

            }
        });
        manager.notifyDataSetChanged();
    }


    public void initFragment(List<ProductSelectBean> list,int fragmentId,Fragment fragment){
//        this.viewPager = viewPager;
        List<Fragment> fragmentList = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            if(i==0){
                FreeChoiceFragment freeChoiceFragment = new FreeChoiceFragment();
                fragmentList.add(freeChoiceFragment);
            }else{
                OtherChoiceFragment otherChoiceFragment = new OtherChoiceFragment();
                otherChoiceFragment.setProductId(list.get(i).getId());
                fragmentList.add(otherChoiceFragment);
            }
        }

        utils = new FragmentSwitchUtils(fragmentList,fragment.getChildFragmentManager(),fragmentId);

//        ChoiceAssetAdapter adapter = new ChoiceAssetAdapter(fragment.getChildFragmentManager(),fragmentList);
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }



}
