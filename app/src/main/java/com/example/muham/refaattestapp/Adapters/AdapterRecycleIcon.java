package com.example.muham.refaattestapp.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.muham.refaattestapp.Holders.HolderRecycleIcon;

public class AdapterRecycleIcon extends RecyclerView.Adapter<HolderRecycleIcon> {

    public int[] dataList;
    private Activity mActivity;

    public AdapterRecycleIcon(Activity activity, int[] data) {
        mActivity = activity;
        dataList = data;

    }

    @NonNull
    @Override
    public HolderRecycleIcon onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HolderRecycleIcon(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecycleIcon holderRecycle, int i) {
        holderRecycle.fillViews(dataList[i], i);


    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }
}


