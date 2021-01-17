package com.example.fragmenttest.ui.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.fragmenttest.R;
import com.reginald.editspinner.EditSpinner;

public class OrderFragment extends Fragment {
    private OrderViewModel orderViewModel;
    private View rootView;
    private EditSpinner spinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_order, container, false);
        orderViewModel = ViewModelProviders.of(this).get(OrderViewModel.class);

        spinner = rootView.findViewById(R.id.checkout_spinner);

        String[] arrayList = {"Cash On Delivery", "Online Payment"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, arrayList);
        spinner.setEditable(false);
        spinner.setAdapter(adapter);
        return rootView;
    }
}