package com.liangke.mvvm.model;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.liangke.adapter.FreeChoiceAdapter;
import com.liangke.adapter.InformationAdapter;
import com.liangke.base.BaseModel;
import com.liangke.comprehensive.R;
import com.liangke.mvvm.bean.BannerBean;
import com.liangke.mvvm.bean.FreeChoiceBean;
import com.liangke.mvvm.bean.InformationBean;
import com.liangke.mvvm.bean.NewsPagesBean;
import com.liangke.mvvm.bean.NewsclassifierBean;
import com.liangke.utils.Utils;
import com.liangke.widget.HorizontalListManager;
import com.liangke.widget.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/18.
 */

public class HomeModel extends BaseModel {

    private final String TAG = HomeModel.class.getSimpleName();

    private ConvenientBanner banner;

    private List<NewsPagesBean> mList = new ArrayList<>();
    private InformationAdapter mAdapter;

    private List<BannerBean> localImages = new ArrayList<BannerBean>();


    public HomeModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void init(RecyclerView recyclerView){

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(mContext, R.drawable.devider_item));
        recyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new InformationAdapter(mContext,mList);
        recyclerView.setAdapter(mAdapter);



    }

    public void initBanner(ConvenientBanner convenientBanner){

        this.banner = convenientBanner;

        //开始自动翻页
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        },localImages)
                //设置指示器是否可见
                .setPointViewVisible(true)
                //设置自动切换（同时设置了切换时间间隔）
                .startTurning(2000)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.dot_unselected, R.drawable.dot_selected})
                //设置指示器的方向（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                //设置点击监听事件
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        showToast("点击"+position);
                    }
                })
                //设置手动影响（设置了该项无法手动切换）
                .setManualPageable(true);

        convenientBanner.invalidate();

    }

    //为了方便改写，来实现复杂布局的切换
    private class LocalImageHolderView implements Holder<BannerBean> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            //你可以通过layout文件来创建，不一定是Image，任何控件都可以进行翻页
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, BannerBean data) {

            Glide.with(mContext).load(localImages.get(position).getBannerUrl()).into(imageView);

        }
    }

    public List<BannerBean> getLocalImages() {
        return localImages;
    }

    public void setLocalImages(List<BannerBean> localImages) {
        if(localImages==null){
            return;
        }
        this.localImages.addAll(localImages);
    }

    public void initClassify(final List<NewsclassifierBean> newsclassifierBeen, HorizontalListView horizontalListView){

        HorizontalListManager manager = horizontalListView.getManager();
        manager.setTxtColor(R.color.white);
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
        manager.notifyDataSetChanged();

    }

    public List<NewsPagesBean> getmList() {
        return mList;
    }

    public void setmList(List<NewsPagesBean> mList) {
        if(mList==null){
            return;
        }
        this.mList.addAll(mList);
        mAdapter.notifyDataSetChanged();
    }
}
