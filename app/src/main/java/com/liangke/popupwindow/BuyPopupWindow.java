package com.liangke.popupwindow;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.PopupBuyBinding;
import com.liangke.mvvm.model.StrategiesModel;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/21.
 */

public class BuyPopupWindow {

    private Context mContext;
    private LayoutInflater inflater;
    private PopupBuyBinding binding;
    private PopupWindow popupWindow;
    private Observer observer;
    private String commdity,productId,price;
    private boolean isShow = false;
    public BuyPopupWindow(Context context, Observer observer) {

        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.observer = observer;
        init();

    }


    private void init(){
        binding = DataBindingUtil.inflate(inflater, R.layout.popup_buy,null,false);
        popupWindow = new PopupWindow(binding.getRoot(), WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        //点击外围消失
        RxView.clicks(binding.llCancel).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                popupWindow.dismiss();
            }
        });
        //点击购买
        RxView.clicks(binding.bBuy).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                StrategiesModel model = new StrategiesModel(mContext,observer);
                model.strategies(productId,1,2,commdity,"1","B","","",price,"","","","","","");
            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                isShow = false;
            }
        });

    }


    public void showAtLocation(View parent, int gravity, int x, int y) {
        isShow = true;
        popupWindow.showAtLocation(parent,gravity,x,y);
    }

    public String getCommdity() {
        return commdity;
    }

    public void setCommdity(String commdity) {
        this.commdity = commdity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
