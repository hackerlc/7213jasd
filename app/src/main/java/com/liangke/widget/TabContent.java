package com.liangke.widget;

/**
 * Created by LK on 2017/12/13.
 */

public class TabContent {

    public int tab_img_unselected;
    public int tab_img_selected;
    public int tab_img_width;
    public int tab_img_height;
    public String tab_txt;
    public int tab_txtColor_selected;
    public int tab_txtColor_unslected;
    public int tab_txt_size = 12;

    public TabContent() {

    }

    public TabContent(int tab_img_unselected, int tab_img_selected, int tab_img_width, int tab_img_height, String tab_txt, int tab_txtColor_selected, int tab_txtColor_unslected, int tab_txt_size) {
        this.tab_img_unselected = tab_img_unselected;
        this.tab_img_selected = tab_img_selected;
        this.tab_img_width = tab_img_width;
        this.tab_img_height = tab_img_height;
        this.tab_txt = tab_txt;
        this.tab_txtColor_selected = tab_txtColor_selected;
        this.tab_txtColor_unslected = tab_txtColor_unslected;
        this.tab_txt_size = tab_txt_size;
    }
}
