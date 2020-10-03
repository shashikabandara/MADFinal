package com.e.salon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class base_page extends AppCompatActivity {
    private ImageButton imageButton;
    private ImageButton  imgAppointments;
    private ImageButton imgLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_page);
        imgLogin = (ImageButton) findViewById(R.id.imgLogin);
        imgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logincustomer();
            }
        });

        imageButton = (ImageButton) findViewById(R.id.imgServices);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openServices();
            }
        });
/*
        imgAppointments = (ImageButton) findViewById(R.id.imgAppointments);
        imgAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openappointments();
            }
        });*/

    }

    public void openServices(){
        Intent intent = new Intent(this,services.class);
        startActivity(intent);
    }
    public void customerService(){
        Intent intent = new Intent(this,customer_service_view.class);
        startActivity(intent);
    }
    public void logincustomer(){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }

   /* public void openappointments(){
        Intent intent = new Intent(this,AddRecordActivity.class);
        startActivity(intent);
    }*/
}