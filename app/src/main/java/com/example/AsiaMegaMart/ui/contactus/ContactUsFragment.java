package com.example.AsiaMegaMart.ui.contactus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.AsiaMegaMart.R;

public class ContactUsFragment extends Fragment {
    private ContactUsViewModel contactUsViewModel;
    private View rootView;

    private ImageView mapbtn;
    private TextView callbtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contact_us, container, false);
        contactUsViewModel = ViewModelProviders.of(this).get(ContactUsViewModel.class);

        mapbtn = rootView.findViewById(R.id.map);
        callbtn = rootView.findViewById(R.id.phone_number);

        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Sultan Ahmed Plaza, Dhaka" ));
                startActivity(intent);
            }
        });

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01858085086"));
                startActivity(intent);
            }
        });

        return rootView;
    }
}