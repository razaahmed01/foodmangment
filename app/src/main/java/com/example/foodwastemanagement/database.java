package com.example.foodwastemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    public static String database="foodwaste";

    public database(@Nullable Context context) {
        super(context, database, null, 1);
//        SQLiteDatabase db =this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,first_name TEXT,last_name TEXT,email TEXT,password TEXT)");
            db.execSQL("CREATE TABLE event (id INTEGER PRIMARY KEY AUTOINCREMENT,event_name TEXT,location TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS users");
            db.execSQL("DROP TABLE IF EXISTS event");
            onCreate(db);

    }

    public boolean userinsert(String f_name,String l_name,String email,String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("first_name",f_name);
        contentValues.put("last_name",l_name);
        contentValues.put("email",email);
        contentValues.put("password",pass);
        long result=db.insert("users",null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean login(String email, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email =? and password =?",new String[]{email,password});
        if (cursor != null) {
            if(cursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }


}
