

package com.example.muham.refaattestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.muham.refaattestapp.Adapters.AdapterRecycleIcon;
import com.example.muham.refaattestapp.Adapters.AdapterRecycleSlider;
import com.example.muham.refaattestapp.Utilities.Constants;
import com.example.muham.refaattestapp.Utilities.SpacesItemDecoration;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private RecyclerView recyclerView_top, recyclerView_bottom, recyclerView_icon;
    private AdapterRecycleSlider adapterTop, adapterBottom;
    private AdapterRecycleIcon adapterIcon;
    private SliderLayout mDemoSlider;
    private CardView search_card_view;
    private ImageView imageSearch;
    private boolean isEtxtShown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        clickConfg();


    }


    private void init() {

        imageSearch = findViewById(R.id.img_search);
        search_card_view = findViewById(R.id.search_card_view);
        adapterTop = new AdapterRecycleSlider(this, Constants.slideTopImages);
        adapterBottom = new AdapterRecycleSlider(this, Constants.slideBottomImages);
        adapterIcon = new AdapterRecycleIcon(this, Constants.iconImages);
        mDemoSlider = findViewById(R.id.slider);


        recyclerView_top = findViewById(R.id.recycler_view_top);
        recyclerView_top.setAdapter(adapterTop);
        recyclerView_top.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_top.setHasFixedSize(true);
        adapterTop.notifyDataSetChanged();

        recyclerView_bottom = findViewById(R.id.recycler_view_bottom);
        recyclerView_bottom.setAdapter(adapterBottom);
        recyclerView_bottom.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_bottom.setHasFixedSize(true);
        adapterBottom.notifyDataSetChanged();


        recyclerView_icon = findViewById(R.id.recycler_view_icons);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        recyclerView_icon.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        recyclerView_icon.setAdapter(adapterIcon);
        recyclerView_icon.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView_icon.setHasFixedSize(true);
        recyclerView_icon.setNestedScrollingEnabled(false);
        adapterBottom.notifyDataSetChanged();


        sliderConfig();
    }

    private void clickConfg() {
        imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEtxtShown) {
                    search_card_view.setVisibility(View.INVISIBLE);
                    isEtxtShown = false;

                } else {
                    search_card_view.setVisibility(View.VISIBLE);
                    isEtxtShown = true;
                }
            }
        });

    }

    private void sliderConfig() {

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.sl1);
        file_maps.put("2", R.drawable.sl2);
        file_maps.put("3", R.drawable.sl3);
        file_maps.put("4", R.drawable.sl4);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(3000);
        mDemoSlider.addOnPageChangeListener(this);
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, "Slider Clicked..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
