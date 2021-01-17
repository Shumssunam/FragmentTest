package com.example.fragmenttest.ui.home;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fragmenttest.R;
import com.example.fragmenttest.adapter.SliderAdapter;
import com.example.fragmenttest.model.SliderModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    View view;
    TextView tvShowall;

    private HomeViewModel homeViewModel;
    private View rootView;
    private SliderAdapter adapter;
    SliderView sliderView;
    private List<SliderModel> mSliderModel = new ArrayList<>();
    private homeFragmentClickListener clickListener;


    
    public HomeFragment(homeFragmentClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        sliderView = rootView.findViewById(R.id.slider);


        LinearLayout linearLayout = rootView.findViewById(R.id.categoris_clickable_section);
        LinearLayout layout = rootView.findViewById(R.id.order_section);


        mSliderModel.add(new SliderModel("description 0",R.drawable.one));
        mSliderModel.add(new SliderModel("description 1",R.drawable.two));
        mSliderModel.add(new SliderModel("description 2",R.drawable.three));
        mSliderModel.add(new SliderModel("description 3",R.drawable.four));

        adapter = new SliderAdapter(getContext(),mSliderModel);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.COLOR);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.startAutoCycle();


        

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.homeToCategory();

            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.homeToOrder();

            }
        });

        return rootView;
    }


    public interface homeFragmentClickListener
    {
        void homeToCategory();
        void homeToOrder();

    }


}