package com.liangke.constants;

import com.liangke.comprehensive.R;
import com.liangke.widget.TabContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/22.
 */

public class TabConstants {

    public static List<TabContent> tabContentList = new ArrayList<>();

    static{
        int[] img_selected = {R.mipmap.tab_home_selected,R.mipmap.tab_market_selected,R.mipmap.tab_position_selected,R.mipmap.tab_community_selected,R.mipmap.tab_mine_selected};
        int[] img_unselected = {R.mipmap.tab_home_unslected,R.mipmap.tab_market_unslected,R.mipmap.tab_position_unselected,R.mipmap.tab_community_unselected,R.mipmap.tab_mine_unslected};
        String[] txt = {"首页","行情","持仓","社区","我的"};

        for(int i = 0;i<5;i++){
            TabContent tabContent = new TabContent();
            tabContent.tab_img_unselected = img_unselected[i];
            tabContent.tab_img_selected = img_selected[i];
            tabContent.tab_txt = txt[i];
            tabContent.tab_txtColor_selected = R.color.blue_04;
            tabContent.tab_txtColor_unslected = R.color.black_03;
            if(i==2){
                tabContent.tab_img_width = 22;
                tabContent.tab_img_height = 22;
            }else{
                tabContent.tab_img_width = 18;
                tabContent.tab_img_height = 18;
            }
            tabContent.tab_txt_size = 12;
            tabContentList.add(tabContent);
        }

    }

}
