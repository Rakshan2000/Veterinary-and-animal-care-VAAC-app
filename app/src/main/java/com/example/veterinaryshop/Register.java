package com.example.veterinaryshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    ImageView img1;
    Button btn2;
    TextView back;
    EditText username,password,email;
    RadioButton radio;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;


    String regularExpr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        img1 = findViewById(R.id.img2);
        username = findViewById(R.id.u2);
        password = findViewById(R.id.p1);
        email = findViewById(R.id.e1);
        radio = findViewById(R.id.r1);
        btn2 = findViewById(R.id.btn2);
        back = findViewById(R.id.back);

        fauth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname = username.getText().toString();
                String pwd = password.getText().toString();
                String Email = email.getText().toString();
                String Radio = radio.getText().toString();
                if(uname.isEmpty()){
                    username.setError("Full Name is Required");
                    return;
                }
                if(pwd.isEmpty()){
                    password.setError("Password is Required");
                    return;
                }
                if(Email.isEmpty()){
                    email.setError("Email is Required");
                    return;
                }
               if(Radio.isEmpty()){
                    radio.setError("Accept the terms and conditions");
                }

                Toast.makeText(Register.this, "Data validated", Toast.LENGTH_LONG).show();
                fauth.createUserWithEmailAndPassword(Email,pwd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser user = fauth.getCurrentUser();
                        DocumentReference df = fstore.collection("Users").document(user.getUid());
                        Map<String,Object> userInfo = new HashMap<>();
                        userInfo.put("FullName",uname);
                        userInfo.put("Email",Email);
                        userInfo.put("Password",pwd);
                        //if user is admin
                        userInfo.put("isuser","1");
                        df.set(userInfo);
                        
                        Toast.makeText(Register.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this,login.class);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(Register.this,e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

}
