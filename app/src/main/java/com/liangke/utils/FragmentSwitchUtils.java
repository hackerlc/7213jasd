package com.liangke.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.LinearLayout;

import com.liangke.comprehensive.mine.MineFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/13.
 */

public class FragmentSwitchUtils {

    private final String TAG = FragmentSwitchUtils.class.getSimpleName();

    private Fragment currentFragment = null,toFragment = null;
    private List<Fragment> fragmentList ;
    private FragmentManager fragmentManager;
    private int fragmentId;

    public FragmentSwitchUtils(List<Fragment> fragmentList, FragmentManager fragmentManager, int fragmentId) {
        this.fragmentList = fragmentList;
        this.fragmentManager = fragmentManager;
        this.fragmentId = fragmentId;
        swtichFragment(0);
    }

    public void swtichFragment(int index){
        toFragment = fragmentList.get(index);
        if(currentFragment==toFragment){
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(!toFragment.isAdded()){
            if(currentFragment!=null){
                transaction.hide(currentFragment);
            }
            transaction.add(fragmentId,toFragment);
        }else{
            if(currentFragment!=null){

                transaction.hide(currentFragment);
            }
            transaction.show(toFragment);
        }
        currentFragment = toFragment;
        transaction.commit();
    }

    public void hide(){
        if(currentFragment!=null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.hide(currentFragment);
            transaction.commit();
        }
    }

    public void show(){
        if(currentFragment!=null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.show(currentFragment);
            transaction.commit();
        }
    }


}
