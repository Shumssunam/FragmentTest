package com.example.fragmenttest.ui.contactus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.fragmenttest.R;

public class ContactUsFragment extends Fragment {
    private ContactUsViewModel contactUsViewModel;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contact_us, container, false);
        contactUsViewModel = ViewModelProviders.of(this).get(ContactUsViewModel.class);
        return rootView;
    }
}