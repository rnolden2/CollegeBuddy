package com.example.randynolden.collegebuddy;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.*;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;

/**
 * Created by randynolden on 7/25/15.
 */
public class Courses extends Activity {


    PopupWindow popUp;
    FrameLayout popup;
    LinearLayout layout;
//    RelativeLayout courses;
    TextView tv;
    LayoutParams params;
    RelativeLayout mainLayout;
    Button button_addcourse;
    Button button_addmanually;
    Button deletedb;
    Button showcourses;

    boolean click = true;
    SQLiteDatabase coursesDB;
    TextView EditText_courselist;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);

        EditText_courselist = (TextView) findViewById(R.id.textView_courselist);
        mainLayout = (RelativeLayout) findViewById(R.id.courses);
//        popUp.isOutsideTouchable(true);
        popup = (FrameLayout) findViewById(R.id.popup);
        button_addmanually = (Button) findViewById(R.id.button_addmanually);
        button_addcourse = (Button) findViewById(R.id.button_addcourse);
        deletedb = (Button) findViewById(R.id.button_deletecourse);
        showcourses = (Button) findViewById(R.id.button_showcourses);

        button_addcourse.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
//                setContentView(R.layout.mathworks);
                if (click) {

                    popup.setVisibility(View.VISIBLE);
                    mainLayout.setBackground(new ColorDrawable(Color.TRANSPARENT));

                    button_addmanually.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                        AddManually();
//                        setContentView(R.layout.addmanually);
                        }
                    });
                    click = false;
                }
                  else {
//                    popUp.dismiss();
                    popup.setVisibility(View.INVISIBLE);
                    click = true;
                }
            }

        });
//        params = new LayoutParams(LayoutParams.WRAP_CONTENT,
//                LayoutParams.WRAP_CONTENT);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        tv.setText("Upload Syllabus or Manual Add");
////        layout.addView(tv, params);
//        layout.addView(tv);
//        popUp.setContentView(layout);
//        // popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
////        mainLayout.addView(button_addcourse, params);
//        setContentView(mainLayout);
    }



    public void getContacts(View view) {

        // A Cursor provides read and write access to database results
        Cursor cursor = coursesDB.rawQuery("SELECT * FROM courses", null);

        // Get the index for the column name provided
        int idColumn = cursor.getColumnIndex("id");
        int nameColumn = cursor.getColumnIndex("name");
        int numberofcreditsColumn = cursor.getColumnIndex("numberofcredits");
        int gradingstyleColumn = cursor.getColumnIndex("gradingstyle");
        int requirementsColumn = cursor.getColumnIndex("requirements");

        // Move to the first row of results
        cursor.moveToFirst();

        String courseList = "";

        // Verify that we have results
        if(cursor != null && (cursor.getCount() > 0)){

            showcourses.setClickable(true);


            do{
                // Get the results and store them in a String
                String id = cursor.getString(idColumn);
                String name = cursor.getString(nameColumn);
                String numberofcredits = cursor.getString(numberofcreditsColumn);
                String gradingstyle = cursor.getString(gradingstyleColumn);
                String requirements = cursor.getString(requirementsColumn);

                courseList = courseList + id + " : " + name + " : " + numberofcredits + " : " + gradingstyle +" : " + requirements +"\n";

                // Keep getting results as long as they exist
            }while(cursor.moveToNext());

            EditText_courselist.setText(courseList);

        } else {

            Toast.makeText(this, "No Results to Show", Toast.LENGTH_SHORT).show();
            EditText_courselist.setText("");

        }

    }
    public void deleteDatabase(View view) {

        // Delete database
        this.deleteDatabase("MyCourses");

    }

    protected void onDestroy() {

        coursesDB.close();

        super.onDestroy();
    }

    public void AddManually() {
        Intent launchList = new Intent(this, AddManually.class);
        startActivity(launchList);
//        popup.setVisibility(View.INVISIBLE);
    }
}

