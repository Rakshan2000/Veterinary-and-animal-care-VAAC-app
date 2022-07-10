package com.example.veterinaryshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class login extends AppCompatActivity {

    //design part
    ImageView image;
    TextView text2;
    EditText email,password;
    Button login;
    FirebaseAuth fauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        image = findViewById(R.id.img);
        text2 = findViewById(R.id.tv2);
        login = findViewById(R.id.login);
        email = findViewById(R.id.u1);
        password = findViewById(R.id.p1);

        fauth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(password.getText().toString().isEmpty()){
                    password.setError("Password is Required");
                    return;
                }
                if(email.getText().toString().isEmpty()){
                    email.setError("Email is Required");
                    return;
                }

                fauth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        Intent intent = new Intent(login.this, Main_Content.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(login.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,MainActivity.class);

                startActivity(intent);
                finish();
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,Register.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            Intent intent = new Intent(getApplicationContext(),Main_Content.class);
            startActivity(intent);
            finish();
    }
  }
}