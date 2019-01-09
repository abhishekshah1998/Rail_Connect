package com.abhishekshah.railconnect;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;


import com.abhishekshah.railconnect.main.main.MainActivity;


public class splash_activity extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 4000;
    public ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        icon = (ImageView) findViewById(R.id.icon1);
        long animationduration = 4000;


        ObjectAnimator animatoralpha = ObjectAnimator.ofFloat(icon,View.ALPHA,0.0f,1.0f);
        animatoralpha.setDuration(animationduration);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(animatoralpha);
        animatorset.start();

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                Intent i = new Intent(splash_activity.this, Intro.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}