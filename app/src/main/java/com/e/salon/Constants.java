package com.e.salon;

public class Constants {

    // db name
    public static final String DB_NAME = "PERSON2 _INFO_DB";
    // db version
    public static final int DB_VERSION = 1;
    // db table name
    public static final String TABLE_NAME_OFFER = "OFFER_INFO_TABLE";
    // columns of table
    public static final String C_ID_OFFER = "ID";
    public static final String C_NAME_OFFER = "NAME";
    public static final String C_PRICE = "PRICE";
    public static final String C_VALID = "VALID";
    public static final String C_IMAGE_OFFER = "IMAGE";
    public static final String C_Add_TIMESTAMP_OFFER = "TIMESTAMP";
    public static final String C_UPDATED_TIMESTAMP_OFFER = "UPDATED_TIMESTAMP";
    // create table query
    public static final String CREATE_TABLE_OFFER = "CREATE TABLE " + TABLE_NAME_OFFER + " ("
            + C_ID_OFFER + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_NAME_OFFER + " TEXT,"
            + C_PRICE + " TEXT,"
            + C_VALID + " TEXT,"
            + C_IMAGE_OFFER + " TEXT,"
            + C_Add_TIMESTAMP_OFFER + " TEXT,"
            + C_UPDATED_TIMESTAMP_OFFER + " TEXT"
            + ");";



    public static final String TABLE_NAME = "PERSON2_INFO_TABLE";
    // columns of table
    public static final String C_ID = "ID";
    public static final String C_NAME = "NAME";
    public static final String C_DATE = "DATE";
    public static final String C_TIME = "TIME";
    public static final String C_TYPE = "TYPE";
    public static final String C_NOTES = "NOTES";
    public static final String C_CNUMBER = "CNUMBER";
    public static final String C_CVC = "CVC";
    public static final String C_EDATE = "EDATE";
    public static final String C_AMOUNT = "AMOUNT";
    public static final String C_PAID = "PAID";
    public static final String C_IMAGE = "IMAGE";
    public static final String C_Add_TIMESTAMP = "TIMESTAMP";
    public static final String C_UPDATED_TIMESTAMP = "UPDATED_TIMESTAMP";
    // create table query
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_NAME + " TEXT,"
            + C_DATE + " TEXT,"
            + C_TIME + " TEXT,"
            + C_IMAGE + " TEXT,"
            + C_TYPE + " TEXT,"
            + C_NOTES + " TEXT,"
            + C_CNUMBER + " TEXT,"
            + C_CVC + " TEXT,"
            + C_EDATE + " TEXT,"
            + C_AMOUNT + " TEXT,"
            + C_PAID + " TEXT,"
            + C_Add_TIMESTAMP + " TEXT,"
            + C_UPDATED_TIMESTAMP + " TEXT"
            + ");";




    //customer
    public static final String TABLE_NAME_CUSTOMER = "REGISTER_INFO_TABLE";
    // columns of table
    public static final String C_ID_CUSTOMER = "ID";
    public static final String C_FNAME = "FNAME";
    public static final String C_LNAME = "LNAME";
    public static final String C_NIC = "NIC";
    public static final String C_CNUMBER_CUSTOMER = "CNUMBER";
    public static final String C_EMAIL = "EMAIL";
    public static final String C_PASSWORD = "PASSWORD";
    public static final String C_CPASSWORD = "CPASSWORD";
    public static final String C_IMAGE_CUSTOMER = "IMAGE";
    public static final String C_Add_TIMESTAMP_CUSTOMER = "TIMESTAMP";
    public static final String C_UPDATED_TIMESTAMP_CUSTOMER = "UPDATED_TIMESTAMP";
    // create table query
    public static final String CREATE_TABLE_CUSTOMER = "CREATE TABLE " + TABLE_NAME_CUSTOMER + " ("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_FNAME + " TEXT,"
            + C_LNAME + " TEXT,"
            + C_NIC + " TEXT,"
            + C_IMAGE + " TEXT,"
            + C_EMAIL + " TEXT,"
            + C_PASSWORD + " TEXT,"
            + C_CNUMBER + " TEXT,"
            + C_CPASSWORD + " TEXT,"
            + C_Add_TIMESTAMP + " TEXT,"
            + C_UPDATED_TIMESTAMP + " TEXT"
            + ");";

}




