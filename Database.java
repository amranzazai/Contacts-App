package com.example.assignment7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper  {
    //Creating string values for column headers
    public static final String COLUMN1 = "ID";
    public static final String COLUMN2 = "NAME";
    public static final String COLUMN3 = "NUMBER";
    public static final String COLUMN4 = "EMAIL";
    public static final String DATABASE_NAME = "contact.db";
    public static final String TABLE_NAME = "contact_table";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase databaseHelper = this.getWritableDatabase();
    }

    //Creating table
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, NUMBER TEXT, EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }

    public boolean insertData(String fullName, String phoneNumber, String emailAddress){
        //Writing  to our database
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //placing content of fullName in column2
        contentValues.put(COLUMN2, fullName);
        //placing content of phoneNumber in column3
        contentValues.put(COLUMN3, phoneNumber);
        //placing content of emailAddress in column4
        contentValues.put(COLUMN4, emailAddress);

        //storing true or false, depending whether or not data was inserted, in result
        long result = database.insert(TABLE_NAME, null, contentValues);

        //if data was not inserted return false
        if (result == -1){
            return false;
        } else {
            //else return true
            return true;
        }
    }

    public List<Contacts> getAllContacts(){
        //New contactList
        List<Contacts> contactList = new ArrayList<>();
        //set db to our database
        SQLiteDatabase database = this.getReadableDatabase();

        //SQL query to read from our database
        String select = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = database.rawQuery(select, null);

        //Getting information from each column and storing in new contact
        if (cursor.moveToFirst()){
            do{
                Contacts contact = new Contacts();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setNumber(cursor.getString(2));
                contact.setEmail(cursor.getString(3));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        //return list of contacts
        return contactList;
    }

    public void deleteData() {
        //set database object to our database
        SQLiteDatabase database = this.getWritableDatabase();
        //SQL query to delete from our table
        database.execSQL("delete from "+ TABLE_NAME);
    }
}
