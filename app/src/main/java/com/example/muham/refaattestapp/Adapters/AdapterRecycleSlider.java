package com.example.muham.refaattestapp.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.muham.refaattestapp.Holders.HolderRecycleSlider;

public class AdapterRecycleSlider extends RecyclerView.Adapter<HolderRecycleSlider> {
    public int[] dataList;
    int recyclerType;
    private Activity mActivity;

    public AdapterRecycleSlider(Activity activity, int[] data) {
        mActivity = activity;
        dataList = data;
        this.recyclerType = recyclerType;

    }

    @NonNull
    @Override
    public HolderRecycleSlider onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HolderRecycleSlider(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecycleSlider holderRecycle, int i) {
        holderRecycle.fillViews(dataList[i], i);


    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }
}
