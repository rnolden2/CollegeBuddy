package com.example.randynolden.collegebuddy;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;


/**
 * Created by randynolden on 1/10/16.
 *
 * This page allows user to manually add their course load information to a database stored within the App
 */
public class AddManually extends Activity{

    Spinner numberofcreditslist;
    Spinner gradingstyles;
    MultiSelectionSpinner requirement;
    Button addmanualcourse;
    SQLiteDatabase coursesDB = null;
    EditText coursename;
    Button deletedb;

    protected void OnCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmanually);

//        helper = new DatabaseHandler(this);
        coursename = (EditText) findViewById(R.id.editText_coursename);
        numberofcreditslist = (Spinner) findViewById(R.id.numberofcreditsspinner);
        gradingstyles = (Spinner) findViewById(R.id.gradingstlyespinner);
        requirement = (MultiSelectionSpinner) findViewById(R.id.requirementspinner);
        addmanualcourse = (Button) findViewById(R.id.button_addtocourselist);
        deletedb = (Button) findViewById(R.id.button_deletecourse);

        addmanualcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//           String name = coursename.getText().toString();
//           String numberofcredits = numberofcreditslist.getSelectedItem().toString();
//           String gradingstyle = gradingstyles.getSelectedItem().toString();
//           String requirements =  requirement.getSelectedItem().toString();
//                String requirements = requirement.getSelectedItemsAsString();
//                Log.e("getSelected", requirements);

//                helper.insert(name,numberofcredits,gradingstyle,requirements);
//                helper.close();
//                setContentView(R.layout.courses);
            }
        });


    }

//    public void createDatabase(View view) {
//
//        try {
//
//            // Opens a current database or creates it
//            // Pass the database name, designate that only this app can use it
//            // and a DatabaseErrorHandler in the case of database corruption
//            coursesDB = this.openOrCreateDatabase("MyCourses", MODE_PRIVATE, null);
//
//            // Execute an SQL statement that isn't select
//            coursesDB.execSQL("CREATE TABLE IF NOT EXISTS courses " +
//                    "(id integer primary key, name VARCHAR, numberofcredits VARCHAR, gradingstyle VARCHAR, requirements VARCHAR);");
//
//            // The database on the file system
//            File database = getApplicationContext().getDatabasePath("MyContacts.db");
//
//            // Check if the database exists
//            if (database.exists()) {
//                Toast.makeText(this, "Database Created", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Database Missing", Toast.LENGTH_SHORT).show();
//            }
//
//        } catch (Exception e) {
//
//            Log.e("COURSES ERROR", "Error Creating Database");
//
//        }
//
//        deletedb.setClickable(true);
//
//    }

    public void addCourse (View view) {

        try {

            // Opens a current database or creates it
            // Pass the database name, designate that only this app can use it
            // and a DatabaseErrorHandler in the case of database corruption
            coursesDB = this.openOrCreateDatabase("MyCourses", MODE_PRIVATE, null);

            // Execute an SQL statement that isn't select
            coursesDB.execSQL("CREATE TABLE IF NOT EXISTS courses " +
                    "(id integer primary key, name VARCHAR, numberofcredits VARCHAR, gradingstyle VARCHAR, requirements VARCHAR);");

            // The database on the file system
            File database = getApplicationContext().getDatabasePath("MyContacts.db");

            // Check if the database exists
            if (database.exists()) {
                Toast.makeText(this, "Database Created", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Database Missing", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {

            Log.e("COURSES ERROR", "Error Creating Database");

        }

        deletedb.setClickable(true);
        // Get the course data entered
        String name = coursename.getText().toString();
        String numberofcredits = numberofcreditslist.getSelectedItem().toString();
        String gradingstyle = gradingstyles.getSelectedItem().toString();
        String requirements =  requirement.getSelectedItem().toString();

        // Execute SQL statement to insert new data
        coursesDB.execSQL("INSERT INTO courses (name, numberofcredits, gradingstyle, requirements) VALUES ('" +
                name + "', '" + numberofcredits + "', '"+ gradingstyle + "', '" + requirements + "');");

    }


    protected void onDestroy() {

        coursesDB.close();

        super.onDestroy();
    }
}
