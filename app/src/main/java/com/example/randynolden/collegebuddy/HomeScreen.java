package com.example.randynolden.collegebuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class HomeScreen extends Activity {

    private ViewFlipper viewFlipper;
    private float lastX;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        listView = (ListView) findViewById(R.id.menu_listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = listView.getItemAtPosition(position);
        switch (position){
            case 0: MathWorks();
                break;
            case 1: Courses();
                break;
            case 2: Orgs();
                break;
            default: NSBENews();
                break;
        }

            }
        });
    }


    // Using the following method, we will handle all screen swaps.
    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                // Handling left to right screen swap.
                if (lastX < currentX) {

                    // If there aren't any other children, just break.
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    // Next screen comes in from left.
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                    // Current screen goes out from right.
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_from_right);

                    // Display next screen.
                    viewFlipper.showNext();
                }

                // Handling right to left screen swap.
                if (lastX > currentX) {

                    // If there is a child (to the left), kust break.
                    if (viewFlipper.getDisplayedChild() == 1)
                        break;

                    // Next screen comes in from right.
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                    // Current screen goes out from left.
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_from_left);

                    // Display previous screen.
                    viewFlipper.showPrevious();
                }
                break;
        }
        return false;
    }
    public void MathWorks() {
        Intent launchList = new Intent(this, MathWorks.class);
        startActivity(launchList);
    }
    public void Courses() {
        Intent launchList = new Intent(this, Courses.class);
        startActivity(launchList);
    }
    public void Orgs() {
        Intent launchList = new Intent(this, Orgs.class);
        startActivity(launchList);
    }
    public void NSBENews() {
        Intent launchList = new Intent(this, NSBENews.class);
        startActivity(launchList);
    }

}
