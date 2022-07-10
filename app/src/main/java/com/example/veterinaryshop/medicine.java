package com.example.veterinaryshop;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class medicine extends AppCompatActivity {

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        ImageView slider1 = findViewById(R.id.slider1);
        AnimationDrawable animationDrawable = (AnimationDrawable) slider1.getDrawable();
        animationDrawable.start();

        ImageView slider2 = findViewById(R.id.slider2);
        AnimationDrawable animationDrawable2 = (AnimationDrawable) slider2.getDrawable();
        animationDrawable2.start();

        ImageView slider3 = findViewById(R.id.slider3);
        AnimationDrawable animationDrawable3 = (AnimationDrawable) slider3.getDrawable();
        animationDrawable3.start();

        ImageView slider4 = findViewById(R.id.slider4);
        AnimationDrawable animationDrawable4 = (AnimationDrawable) slider4.getDrawable();
        animationDrawable4.start();


        back = findViewById(R.id.back5);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(medicine.this,Main_Content.class);
                startActivity(intent);
                finish();
            }
        });


    }
}