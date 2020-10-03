package com.e.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

        EditText txt_username,txt_password;
        Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_password);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_username.getText().toString().equals("admin") && (txt_password.getText().toString().equals("admin123"))) {
                    movePage();
                }
                else{
                    customerService();
                }
            }
        });
    }
        public void movePage(){
            Intent intent = new Intent(this,base_page.class);
            startActivity(intent);
        }

    public void customerService(){
        Intent intent = new Intent(this,customer_service_view.class);
        startActivity(intent);
    }
}