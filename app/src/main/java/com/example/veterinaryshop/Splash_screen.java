package com.example.veterinaryshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_screen extends AppCompatActivity {

    private static int SPLASH_SCREEN=5000;

    Animation topanim,botanim;
    ImageView logo;
    TextView main,side;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
       topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
       botanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

       logo = findViewById(R.id.img3);
       main = findViewById(R.id.vaac);
       side = findViewById(R.id.slogan);

       logo.setAnimation(topanim);
       main.setAnimation(botanim);
       side.setAnimation(botanim);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(Splash_screen.this,MainActivity.class);
               startActivity(intent);
               finish();
           }
       },SPLASH_SCREEN);


    }
}