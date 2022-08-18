package com.project.bookreview.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String database_name = "review_db";
    public static final String database_table = "review_table";


    public DBHelper(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + database_table + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TYTUL TEXT,RECENZJA TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + database_table);
        onCreate(db);
    }

    public boolean wstawDane(String tytul, String recenzja) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TYTUL", tytul);
        cv.put("RECENZJA", recenzja);
        if (db.insert(database_table, null, cv) == -1) {
            return false;
        } else
            return true;
    }

    public SQLiteCursor pobierzDane() {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteCursor kursor = (SQLiteCursor) db.rawQuery("SELECT * FROM " + database_table, null);
        return kursor;
    }
}
