package com.example.randynolden.collegebuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

/**
 * Created by randynolden on 7/25/15.
 *
 * Main page for Math related functions.
 */
public class MathWorks extends Activity {

    private ListView listView;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathworks);

        listView = (ListView) findViewById(R.id.mathworks_listView1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                switch (position) {
                    case 0:
                        GPA();
                        break;
                    case 1:
                        Gratuity();
                        break;
                    case 2:

                        AlertDialog alertDialog = new AlertDialog.Builder(MathWorks.this).create();
                        alertDialog.setTitle("Lottory Number");
                        alertDialog.setMessage(LottoryNumbers.LotteryNum());
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        break;
                    case 3:
                        EquationList();
                        break;
                    default:
                        Gratuity();
                        break;
                }
            }
        });

    }
    public void GPA() {
        Intent launchList = new Intent(this, GPA.class);
        startActivity(launchList);
    }
    public void Gratuity() {
        Intent launchList = new Intent(this, Gratuity.class);
        startActivity(launchList);
    }
    public void LottoryNumbers() {
//        Intent launchList = new Intent(this, LottoryNumbers.class);
//        startActivity(launchList);
    }
    public void EquationList() {
        Intent launchList = new Intent(this, EquationList.class);
        startActivity(launchList);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
