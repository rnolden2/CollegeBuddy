package com.example.randynolden.collegebuddy;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by randynolden on 8/15/15.
 */
public class LottoryNumbers extends Activity {

    public static String LotteryNum(){

        StringBuilder lotto = new StringBuilder();

//        for (int j = 0; j < 1; j++) {


            for (int i = 0; i < 6; i++){
                if (i <= 4){
                    int rand = Rannum();
                    while (rand == 0){
                        rand = Rannum();
                    }
                    lotto.append(" " + rand + " ");
//                    lotto.append("");
                }

                else {
                    int rand = Ranred();
                    while (rand == 0){
                        rand = Ranred();
                    }
                    lotto.append(" PB ");
                    lotto.append(rand);
                }
            }

//            System.out.println(lotto + "\n");
//        }
        String lottonumber = lotto.toString();
        lottonumber.concat(",");
        return lottonumber;
    }
    public static int Rannum(){

        Random generator = new Random();
        int x = generator.nextInt(69); // Random number between 0 and 69

        return x;
    }

    public static int Ranred(){

        Random generator = new Random();
        int x = generator.nextInt(26); // Random number between 0 and 26

        return x;
    }
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.lottery);
//    }
}
