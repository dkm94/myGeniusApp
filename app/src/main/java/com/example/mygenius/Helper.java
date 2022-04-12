package com.example.mygenius;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    public static final String DB = "Login.db";
    public Helper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(_id INTEGER PRIMARY KEY, username TEXT, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE if exists users");
    }

    public Boolean insertData(String username, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result= db.insert("users", null, contentValues);
        if(result==-1){
            return false;
        } else
            return true;
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM users WHERE email = ?", new String[]{email});
        if(cursor.getCount() > 0){
            return true;
        } else
            return false;

    }

    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM users WHERE email = ? AND password = ? ", new String[]{email, password});
        if(cursor.getCount() > 0){
            return true;
        } else
            return false;
    }
}
