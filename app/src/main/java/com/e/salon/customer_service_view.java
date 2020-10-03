package com.e.salon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class customer_service_view extends AppCompatActivity {

    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service_view);
        myDB = new DBHelper(this);
        viewAll();
    }

    //view all data
    public void viewAll(){

                Cursor res = myDB.getServiceData();

                if(res.getCount() == 0 ){
                    showMessage("Error","Noting Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id : " + res.getString(0)+ "\n");
                    buffer.append("Service Name : " + res.getString(1)+ "\n");
                    buffer.append("Provider Name : " + res.getString(2)+ "\n");
                    buffer.append("Price : " + res.getString(3)+ "\n");
                    buffer.append("\n");
                }

                showMessage("Data",buffer.toString());
            }


    //message
    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



}