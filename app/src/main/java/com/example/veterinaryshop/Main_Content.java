package com.example.veterinaryshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Main_Content extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigation;
    Toolbar toolbar;
    TextView nav_login;
    ImageView doctor,hospital,helpline,medicine,burns,bleed,fracture,shock,stroke,poison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigation= findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        hospital = findViewById(R.id.hospital);
        doctor = findViewById(R.id.doctor);
        helpline = findViewById(R.id.helpline);
        medicine = findViewById(R.id.medicine);


        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Content.this,doctor.class);
                startActivity(intent);
                finish();
            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Content.this,hospital.class);
                startActivity(intent);
                finish();
            }
        });
        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Content.this,helpline.class);
                startActivity(intent);
                finish();
            }
        });
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Content.this,medicine.class);
                startActivity(intent);
                finish();
            }
        });

        //hide or show the item
        Menu menu = navigation.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);


        setSupportActionBar(toolbar);

        navigation.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigation.setNavigationItemSelectedListener(this);
        navigation.setCheckedItem(R.id.nav_home);


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                break;
            case R.id.nav_doctor:
                Intent doctor = new Intent(Main_Content.this,doctor.class);
                 startActivity(doctor);
                 break;
            case  R.id.nav_login:
                FirebaseAuth.getInstance().signOut();
                Intent login = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(login);
                break;
            case R.id.Share:
                Toast.makeText(this,"Share",Toast.LENGTH_LONG ).show();
                break;
            case R.id.nav_hospital:
                Intent hospital = new Intent(Main_Content.this,doctor.class);
                startActivity(hospital);
                break;
            case R.id.nav_helpline:
                Intent helpline = new Intent(Main_Content.this,helpline.class);
                startActivity(helpline);
                break;
            case R.id.nav_medicine:
                Intent medicine = new Intent(Main_Content.this,medicine.class);
                startActivity(medicine);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}