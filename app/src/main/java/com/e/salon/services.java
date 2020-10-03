package com.e.salon;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class services extends AppCompatActivity {

    DBHelper myDB;
    EditText service_name,provider_name,price,id,id_del;
    Button btnAddService,btnViewService,btnUpdateService,btnDeleteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        myDB = new DBHelper(this);

        id =(EditText) findViewById(R.id.id);
        service_name = (EditText) findViewById(R.id.service_name);
        provider_name = (EditText) findViewById(R.id.provider_name);
        price = (EditText) findViewById(R.id.price);
        btnAddService = (Button) findViewById(R.id.btnAddService);
        btnViewService = (Button) findViewById(R.id.btnViewService);
        btnUpdateService = (Button) findViewById(R.id.btnUpdateService);
        btnDeleteService = (Button) findViewById(R.id.btnDeleteService);

        addData();
        viewAll();
        updateData();
        deleteData();
    }

    //insert data
    public void addData(){
        btnAddService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted = myDB.insertServiceData(service_name.getText().toString(), provider_name.getText().toString(), price.getText().toString());
                if(service_name.getText().toString().length() != 0) {
                    if (provider_name.getText().toString().length() != 0) {
                        if (price.getText().toString().length() != 0) {
                            if (isInserted == true) {
                                Toast.makeText(services.this, "New record inserted", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(services.this, " record not inserted", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(services.this, " Field cannot be empty", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(services.this, " Field cannot be empty", Toast.LENGTH_LONG).show();
                    }

                } else{
                    Toast.makeText(services.this, " Field cannot be empty", Toast.LENGTH_LONG).show();
                }
                clearText();
            }
        });

}

//view all data
    public void viewAll(){
        btnViewService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                clearText();
            }
        });
    }

    //message
    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    //update data
    public void updateData() {
        btnUpdateService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated = myDB.updateServiceData(id.getText().toString(),service_name.getText().toString(), provider_name.getText().toString(), price.getText().toString());
                if(service_name.getText().toString().length() != 0) {
                    if (provider_name.getText().toString().length() != 0) {
                        if (price.getText().toString().length() != 0) {
                            if (isUpdated == true) {
                                Toast.makeText(services.this, " record Updated", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(services.this, " record not updated", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(services.this, " Field cannot be empty", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(services.this, " Field cannot be empty", Toast.LENGTH_LONG).show();
                    }

                } else{
                    Toast.makeText(services.this, " Field cannot be empty", Toast.LENGTH_LONG).show();
                }

                clearText();
            }
        });
    }

    public void deleteData() {
        btnDeleteService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleteRows;
                deleteRows = myDB.deleteServiceData(id.getText().toString());

                if(deleteRows > 0){
                    Toast.makeText(services.this, " record Deleted", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(services.this, " record deleted", Toast.LENGTH_LONG).show();
                }
                clearText();
            }

        });
    }

    public void clearText(){
        id.setText(" ");
        service_name.setText(" ");
        provider_name.setText(" ");
        price.setText(" ");

    }
}

