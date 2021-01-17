package com.example.fragmenttest.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmenttest.R;


public class RegistrationFragment extends Fragment {

    private View rootView;


    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        rootView = inflater.inflate(R.layout.fragment_registration, container, false);


        return rootView;
    }
}