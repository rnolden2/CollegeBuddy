package com.example.randynolden.collegebuddy;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by randynolden on 8/15/15.
 *
 * Here the user can keep track of their grades and visually see their GPA change.
 * They will be able to see cumulative as well as their semester GPA.
 *
 */
public class GPA extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpa);
    }
}
