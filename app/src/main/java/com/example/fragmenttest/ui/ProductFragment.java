package com.example.fragmenttest.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmenttest.R;
import com.example.fragmenttest.ui.wishlist.WishlistViewModel;
import com.google.android.material.slider.Slider;
import com.smarteist.autoimageslider.SliderView;


public class ProductFragment extends Fragment {

    private View rootView;
    public ProductFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_product, container, false);
        return rootView;


    }
}