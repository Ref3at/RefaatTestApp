package com.example.muham.refaattestapp.Utilities;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = 0;
        outRect.right = space;
        outRect.bottom = space;


        if (parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1) {

            outRect.top = space;

        } else
            outRect.top = 0;

//        if (parent.getChildLayoutPosition(view) == 6 || parent.getChildLayoutPosition(view) == 7){
//
//            outRect.bottom = space;
//
//        }else
//            outRect.bottom = 0;
    }
}