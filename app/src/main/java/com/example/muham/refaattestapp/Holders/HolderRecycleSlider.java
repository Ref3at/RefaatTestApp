package com.example.muham.refaattestapp.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.muham.refaattestapp.R;

public class HolderRecycleSlider extends RecyclerView.ViewHolder {


    public HolderRecycleSlider(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_recycle_slider, parent, false));


    }


    public void fillViews(int drawableId, final int position) {
        ImageView imageView = itemView.findViewById(R.id.item_image);
        imageView.setImageResource(drawableId);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Slider No. " + position + " Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
