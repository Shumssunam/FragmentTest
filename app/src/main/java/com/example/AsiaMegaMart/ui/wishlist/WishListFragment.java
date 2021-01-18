package com.example.AsiaMegaMart.ui.wishlist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.AsiaMegaMart.R;

public class WishListFragment extends Fragment {
    private WishlistViewModel wishlistViewModel;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_wishlist, container, false);
        wishlistViewModel = ViewModelProviders.of(this).get(WishlistViewModel.class);
        return rootView;
    }
}