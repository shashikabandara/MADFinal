package com.e.salon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CusDatabaseHelper extends SQLiteOpenHelper {

    public CusDatabaseHelper(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ Constants.TABLE_NAME);
        onCreate(db);
    }

    // insert information
    public long insertInfo(String image, String fname, String lname, String nic, String cnumber, String email, String password, String cpassword, String addTimeStamp, String updateTimeStamp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.C_FNAME, fname);
        values.put(Constants.C_LNAME, lname);
        values.put(Constants.C_NIC, nic);
        values.put(Constants.C_IMAGE, image);
        values.put(Constants.C_CNUMBER, cnumber);
        values.put(Constants.C_EMAIL, email);
        values.put(Constants.C_CNUMBER, cnumber);
        values.put(Constants.C_PASSWORD, password);
        values.put(Constants.C_CPASSWORD, cpassword);
        values.put(Constants.C_Add_TIMESTAMP, addTimeStamp);
        values.put(Constants.C_UPDATED_TIMESTAMP, updateTimeStamp);

        long id = db.insert(Constants.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    // update information
    public void updateInfo(String id, String image,String fname, String lname, String nic, String cnumber, String email, String password, String cpassword, String addTimeStamp, String updateTimeStamp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.C_FNAME, fname);
        values.put(Constants.C_LNAME, lname);
        values.put(Constants.C_NIC, nic);
        values.put(Constants.C_IMAGE, image);
        values.put(Constants.C_EMAIL, email);
        values.put(Constants.C_PASSWORD, password);
        values.put(Constants.C_CNUMBER, cnumber);
        values.put(Constants.C_CPASSWORD, cpassword);
        values.put(Constants.C_Add_TIMESTAMP, addTimeStamp);
        values.put(Constants.C_UPDATED_TIMESTAMP, updateTimeStamp);

        db.update(Constants.TABLE_NAME, values, Constants.C_ID + " = ?", new String[]{id});
        db.close();
    }

    // delete information
    public void deleteInfo(String id) {

        SQLiteDatabase db = getWritableDatabase();
        db.delete(Constants.TABLE_NAME, Constants.C_ID + " = ?", new String[]{id});
        db.close();
    }

    public ArrayList<CusModel> getAllData(String orderBy) {

        ArrayList<CusModel> arrayList = new ArrayList<>();
        // query for select info
        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " ORDER BY " + orderBy;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToNext()) {
            do {
                CusModel cusModel = new CusModel(
                ""+cursor.getInt(cursor.getColumnIndex(Constants.C_ID)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_FNAME)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_LNAME)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_NIC)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_CNUMBER)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_EMAIL)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_PASSWORD)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_CPASSWORD)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_Add_TIMESTAMP)),
                ""+cursor.getString(cursor.getColumnIndex(Constants.C_UPDATED_TIMESTAMP))

                );
                arrayList.add(cusModel);
            }while (cursor.moveToNext());
        }

        db.close();
        return arrayList;
    }

    /*public int getCounts() {
        String countQuery = "SELECT * FROM " + Constants.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();
        return count;
    }*/
}
