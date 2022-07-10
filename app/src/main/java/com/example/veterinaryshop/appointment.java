package com.example.veterinaryshop;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class appointment extends AppCompatActivity {

    EditText date_of_birth,date_of_appointment,First_name,Last_name,Phone_number;
    Spinner Time,doctor;
    Button submit;
    DatePickerDialog.OnDateSetListener setListener;
    ImageView back;
    TextView back_text;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        First_name = findViewById(R.id.first);
        Last_name = findViewById(R.id.last);
        date_of_birth = findViewById(R.id.dob);
        date_of_appointment = findViewById(R.id.doa);
        Time = findViewById(R.id.time_ap);
        doctor = findViewById(R.id.doctor_ap);
        Phone_number = findViewById(R.id.phone);
        submit = findViewById(R.id.submit_ap);
        back = findViewById(R.id.back4);
        back_text = findViewById(R.id.back_text);

        fauth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(appointment.this,hospital.class);
                startActivity(intent);
                finish();
            }
        });
        back_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(appointment.this,hospital.class);
                startActivity(intent);
                finish();
            }
        });
        date_of_birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        appointment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        date_of_birth.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        date_of_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        appointment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        date_of_appointment.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = First_name.getText().toString();
                String lname = Last_name.getText().toString();
                String dob = date_of_birth.getText().toString();
                String doa = date_of_appointment.getText().toString();
                String doc = doctor.getSelectedItem().toString();
                String time = Time.getSelectedItem().toString();
                String Phone = Phone_number.getText().toString();
                if(fname.isEmpty()){
                    First_name.setError("Full Name is Required");
                    return;
                }
                if(dob.isEmpty()){
                    date_of_birth.setError("Date of birth is Required");
                    return;
                }
                if(doa.isEmpty())
                {
                    date_of_appointment.setError("date of appointment is required");
                }
                if(Phone.isEmpty())
                {
                    Phone_number.setError("Phone Number is required");
                }
                Toast.makeText(appointment.this, "Data validated", Toast.LENGTH_LONG).show();
                Map<String,Object> apInfo = new HashMap<>();
                apInfo.put("First Name",fname);
                apInfo.put("Last Name",lname);
                apInfo.put("Date of Birth",dob);
                apInfo.put("Date of Appointment",doa);
                apInfo.put("Doctor Name",doc);
                apInfo.put("Appointment time",time);
                apInfo.put("Phone Number",Phone);

                fstore.collection("Appointment").add(apInfo).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(appointment.this, "Appointment Accepted", Toast.LENGTH_LONG).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {

                        Toast.makeText(appointment.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}