package com.example.AsiaMegaMart.ui.conditionsterms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.AsiaMegaMart.R;

public class ConditionsAndTermsFragment extends Fragment {
    private ConditionsViewModel conditionsViewModel;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_terms_conditions, container, false);
        conditionsViewModel = ViewModelProviders.of(this).get(ConditionsViewModel.class);
        return rootView;
    }
}