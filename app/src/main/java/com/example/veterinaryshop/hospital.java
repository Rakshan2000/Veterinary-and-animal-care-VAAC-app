package com.example.veterinaryshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class hospital extends AppCompatActivity {

    ImageView map1,back;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        map1 = findViewById(R.id.map1);
        book = findViewById(R.id.book1);
        back = findViewById(R.id.back3);

        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:19.133376687134195, 72.83534462481427"));
                Intent chooser = Intent.createChooser(intent,"Lanch Maps");
                startActivity(chooser);
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this,appointment.class);
                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this,Main_Content.class);
                startActivity(intent);
                finish();
            }
        });
    }
}