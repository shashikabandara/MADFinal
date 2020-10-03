package com.e.salon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "PERSON2 _INFO_DB";
    public static final String SERVICE_TABLE_NAME = "SERVICE_INFO_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 ="SERVICE_NAME";
    public static final String COL_3 ="PROVIDER_NAME";
    public static final String COL_4 ="PRICE";



    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
       // DB.execSQL("CREATE TABLE SERVICE_INFO_TABLE (ID INTEGER PRIMARY KEY AUTOINCREMENT,SERVICE_NAME TEXT,PROVIDER_NAME TEXT , PRICE TEXT)");
        DB.execSQL( "CREATE TABLE " + SERVICE_TABLE_NAME + " ("
                + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_2 + " TEXT,"
                + COL_3 + " TEXT,"
                + COL_4 + " TEXT"+ " )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + SERVICE_TABLE_NAME);
        onCreate(DB);
    }


    public boolean insertServiceData(String service_name,String provider_name,String price){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,service_name);
        contentValues.put(COL_3,provider_name);
        contentValues.put(COL_4,price);

       long result = DB.insert("SERVICE_INFO_TABLE",null,contentValues);

        if(result == -1){
            return false;
        }else{
            return  true;
        }
    }

    public boolean updateServiceData(String id,String service_name,String provider_name,String price){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,service_name);
        contentValues.put(COL_3,provider_name);
        contentValues.put(COL_4,price);


        //Cursor cursor = DB.rawQuery("SELECT * FROM " + SERVICE_TABLE_NAME  + " WHERE service_name =? ",new String[]{service_name});
       // if(cursor.getCount() > 0 ) {long result =
            DB.update("SERVICE_INFO_TABLE", contentValues, "ID  =? ", new String[]{id});
         return true;
           // if (result == -1) {
           //     return false;
           // } else {
            //    return true;
            //}

    }

    public Integer deleteServiceData(String id){
        SQLiteDatabase DB = this.getWritableDatabase();

            return DB.delete("SERVICE_INFO_TABLE", "ID = ? ", new String[]{id});

    }


    public Cursor getServiceData(){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("SELECT * FROM " + SERVICE_TABLE_NAME ,null);
        return cursor;
    }


    public Cursor getSelectedServiceData(String id){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("SELECT * FROM SERVICE_INFO_TABLE WHERE id =? ",new String[]{id});
       return cursor;
    }


}
