package com.montanez.betzy.prueba_grability.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.montanez.betzy.prueba_grability.R;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1500;

    private Animation animFadein;
    private ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Controles
        imgLogo = (ImageView) findViewById(R.id.logo);

        // Animacion
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        imgLogo.startAnimation(animFadein);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent appCategoryIntent = new Intent(SplashActivity.this, AppCategoryActivity.class);
                SplashActivity.this.startActivity(appCategoryIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
