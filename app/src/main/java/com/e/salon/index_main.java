package com.e.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class index_main extends AppCompatActivity {

    private ImageButton imageButton;
    private ImageButton  imgAppointments;
    private ImageButton imgLogin;
    private  ImageButton imgOffers;
    private ImageButton imgregistration;
    private ImageButton imgContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_main);


        imgLogin = (ImageButton) findViewById(R.id.imgLogin);
        imgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logincustomer();
            }
        });

        imgContact = (ImageButton) findViewById(R.id.imgContact);
        imgContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactDetails();
            }
        });

        imgregistration = (ImageButton) findViewById(R.id.imgregistration);
        imgregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                custumerRegistration();
            }
        });

        imageButton = (ImageButton) findViewById(R.id.imgServices);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customerService();
            }
        });

        //redirect to offers page
        imgOffers = (ImageButton) findViewById(R.id.imgOffers);
        imgOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offersDetails();
            }
        });

        imgAppointments = (ImageButton) findViewById(R.id.imgAppointments);
        imgAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openappointments();
            }
        });

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
    //offers
    public void offersDetails(){
        Intent intent = new Intent(this,OfferMainActivity.class);
        startActivity(intent);
    }

    public void openappointments(){
        Intent intent = new Intent(this,AddRecordActivity.class);
        startActivity(intent);
    }

    public void custumerRegistration(){
        Intent intent = new Intent(this,CusAddRecordActivity.class);
        startActivity(intent);
    }

    public void contactDetails(){
        Intent intent = new Intent(this,contact.class);
        startActivity(intent);
    }
}