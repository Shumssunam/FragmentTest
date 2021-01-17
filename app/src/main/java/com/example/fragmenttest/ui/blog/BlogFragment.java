package com.example.fragmenttest.ui.blog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.fragmenttest.R;

public class BlogFragment extends Fragment  {
    private BlogViewModel blogViewModel;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_blog, container, false);
        blogViewModel = ViewModelProviders.of(this).get(BlogViewModel.class);
        return rootView;
    }
}