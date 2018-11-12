package com.example.muham.refaattestapp.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.muham.refaattestapp.R;

public class HolderRecycleIcon extends RecyclerView.ViewHolder {


    public HolderRecycleIcon(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_recycler_icon, parent, false));


    }


    public void fillViews(int drawableId, final int postition) {
        ImageView imageView = itemView.findViewById(R.id.item_image);
        imageView.setImageResource(drawableId);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Icon No. " + postition + " Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
