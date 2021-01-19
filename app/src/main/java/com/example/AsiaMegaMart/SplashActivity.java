package com.example.AsiaMegaMart;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.half_logo);

        Thread splash = new Thread() {
            public void run() {

                try {
                    sleep(2 * 700);
                    Intent intent = new Intent(com.example.AsiaMegaMart.SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };


        splash.start();


        imageView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
    }


}