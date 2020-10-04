package com.e.salon;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CusMainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView mRecyclerView;
    private CusDatabaseHelper cusDatabaseHelper;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cusactivity_main);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Profile");

        fab = findViewById(R.id.addFabButton);
        mRecyclerView = findViewById(R.id.recyclerView);


        cusDatabaseHelper = new CusDatabaseHelper(this);

        showRecord();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CusMainActivity.this, CusAddRecordActivity.class);
                intent.putExtra("editMode", false);
                startActivity(intent);
            }
        });
    }

    private void showRecord() {

        CusAdapter cusAdapter = new CusAdapter(CusMainActivity.this,
                cusDatabaseHelper.getAllData(Constants.C_Add_TIMESTAMP + " DESC"));

        mRecyclerView.setAdapter(cusAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showRecord();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }

        return super.onKeyDown(keyCode, event);
    }
}
