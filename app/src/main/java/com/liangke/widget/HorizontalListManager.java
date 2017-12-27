package com.liangke.widget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.liangke.base.BaseRecyclerViewAdapter;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ItemChannelhorizontalBinding;
import com.liangke.mvvm.bean.ChannelBean;
import com.liangke.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/19.
 */

public class HorizontalListManager {

    private final String TAG = HorizontalListManager.class.getSimpleName();

    private Context mContext;
    private HorizontalListView listView;

    private HorizontalListViewAdapter adapter;

    private int txtColor = R.color.black_01;

    private int txtSelectedColor = Integer.MAX_VALUE;
    private int txtUnSelectedColor = Integer.MAX_VALUE;

    private int selectedPosition = 0;

    private OnBindTextListener onBindTextListener;

    private OnItemClickListener onItemClickListener;

    public HorizontalListManager(Context context,HorizontalListView view) {
        this.mContext = context;
        this.listView = view;
        init();
    }

    private void init(){

        listView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        adapter = new HorizontalListViewAdapter();
        listView.setAdapter(adapter);

    }


    public class HorizontalListViewAdapter extends RecyclerView.Adapter<HorizontalListViewAdapter.HorizontalListViewHolder>{


        @Override
        public HorizontalListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            ItemChannelhorizontalBinding binding = ItemChannelhorizontalBinding.inflate(LayoutInflater.from(mContext),parent,false);
            return new HorizontalListViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(HorizontalListViewHolder holder, final int position) {
            if(onBindTextListener!=null){
                holder.binding.tvName.setText(onBindTextListener.onBindText(position));
                if(txtSelectedColor==Integer.MAX_VALUE||txtUnSelectedColor==Integer.MAX_VALUE){
                    holder.binding.tvName.setTextColor(ContextCompat.getColor(mContext,txtColor));
                }else{
                    if(selectedPosition==position){
                        holder.binding.tvName.setTextColor(ContextCompat.getColor(mContext,txtSelectedColor));
                    }else{
                        holder.binding.tvName.setTextColor(ContextCompat.getColor(mContext,txtUnSelectedColor));
                    }
                }
                if(onItemClickListener!=null){
                    holder.binding.tvName.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onItemClickListener.onItemClick(position);
                            selectedPosition = position;
                            notifyDataSetChanged();
                        }
                    });
                }
            }

        }

        @Override
        public int getItemCount() {
            int count = 0;
            if(onBindTextListener!=null){
                count = onBindTextListener.getSize();
            }
            return count;
        }

        public class HorizontalListViewHolder extends RecyclerView.ViewHolder{
            ItemChannelhorizontalBinding binding;

            public HorizontalListViewHolder(ItemChannelhorizontalBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

        }

    }

    public int getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(int txtColor) {
        this.txtColor = txtColor;
    }

    public interface OnBindTextListener{
        public String onBindText(int position);

        public int getSize();
    }

    public void notifyDataSetChanged(){
        adapter.notifyDataSetChanged();
    }

    public OnBindTextListener getOnBindTextListener() {
        return onBindTextListener;
    }

    public void setOnBindTextListener(OnBindTextListener onBindTextListener) {
        this.onBindTextListener = onBindTextListener;
    }


    public int getTxtSelectedColor() {
        return txtSelectedColor;
    }

    public void setTxtSelectedColor(int txtSelectedColor) {
        this.txtSelectedColor = txtSelectedColor;
    }

    public int getTxtUnSelectedColor() {
        return txtUnSelectedColor;
    }

    public void setTxtUnSelectedColor(int txtUnSelectedColor) {
        this.txtUnSelectedColor = txtUnSelectedColor;
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        adapter.notifyDataSetChanged();
    }

    public interface OnItemClickListener{
        public void onItemClick(int position);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
