package com.example.AsiaMegaMart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.AsiaMegaMart.R;
import com.example.AsiaMegaMart.model.SliderModel;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.sliderHolder> {

    private List<SliderModel> mSliderModel = new ArrayList<>();
    private Context context;

    public SliderAdapter(Context context, List<SliderModel> mSliderModel) {
        this.context = context;
        this.mSliderModel = mSliderModel;

    }


    @Override
    public sliderHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, parent, false);
        return new sliderHolder(view);
    }

    @Override
    public void onBindViewHolder(sliderHolder viewHolder, final int position) {

        SliderModel sliderModel = mSliderModel.get(position);
        viewHolder.textViewDescription.setText(sliderModel.getDescription());
        viewHolder.imageViewBackground.setImageResource(sliderModel.getUrl());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {

        return mSliderModel.size();
    }

    public class sliderHolder extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public sliderHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;

        }
    }
}
