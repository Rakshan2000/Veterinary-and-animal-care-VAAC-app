package com.example.veterinaryshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class helpline extends AppCompatActivity {
    ImageView back;
    ImageView phone1,phone2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        back = findViewById(R.id.back4);
        phone1 = findViewById(R.id.phone1);
        phone2 = findViewById(R.id.phone2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(helpline.this,Main_Content.class);
                startActivity(intent);
                finish();
            }
        });

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:9483303321"));
                startActivity(intent);
            }
        });
    }
}