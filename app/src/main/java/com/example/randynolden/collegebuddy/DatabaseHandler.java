package com.example.randynolden.collegebuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by randynolden on 1/31/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {


        private static final String DATABASE_NAME="courses.db"; private static final int SCHEMA_VERSION=1;
        public DatabaseHandler(Context context) {
            super(context, DATABASE_NAME, null, SCHEMA_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE courses (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, numberofcredits TEXT, style TEXT, requirements TEXT);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // no-op, since will not be called until 2nd schema
        }
            public Cursor getAll() {
                return (getReadableDatabase()
                        .rawQuery("SELECT _id, name, numberofcredits, style, requirements FROM course ORDER BY name", null));
            }
            public void insert(String name, String numberofcredits, String style, String requirements) {
                ContentValues cv=new ContentValues();
                cv.put("name", name); cv.put("address", numberofcredits); cv.put("type", style); cv.put("notes", requirements);
                getWritableDatabase().insert("Courses", "name", cv); }
            public String getName(Cursor c) {
                return(c.getString(1)); }
            public String getNumberofcredits(Cursor c) {
                return(c.getString(2)); }
            public String getStyle(Cursor c) {
                return(c.getString(3)); }
            public String getRequirements(Cursor c) {
                return(c.getString(4)); }

    }
