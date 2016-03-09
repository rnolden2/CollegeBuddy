package com.example.randynolden.collegebuddy;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by randynolden on 8/15/15.
 */



public class Gratuity extends Activity {

    Button roundup_button;
    Button change_percentages;
    EditText bill_amount;
    TextView amount_at_15_textView;
    TextView amount_at_18_textView;
    TextView amount_at_20_textView;
    TextView total_with_15_textView;
    TextView total_with_18_textView;
    TextView total_with_20_textView;
    private double ans = 0.0;
    private double total = 0.0;




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips);
// app has just started
//        if (savedInstanceState == null){
//            total_with_15 = 0.0;
//            total_with_18 = 0.0;
//            total_with_20 = 0.0;
//            amount_at_15 = 0.0;
//            amount_at_18 = 0.0;
//            amount_at_20 = 0.0;
//            totalbill = 0.0;
//        }
//        // app has resumed and saved numbers are restored
//        else {
//            amount_at_15 = savedInstanceState.getDouble(percent15);
//            amount_at_18 = savedInstanceState.getDouble(percent18);
//            amount_at_20 = savedInstanceState.getDouble(percent20);
//            total_with_15 = savedInstanceState.getDouble(total15);
//            total_with_18 = savedInstanceState.getDouble(total18);
//            total_with_20 = savedInstanceState.getDouble(total20);
//
//            totalbill = savedInstanceState.getDouble(totalBill);
//
//        }
        bill_amount = (EditText) findViewById(R.id.bill_amount);

        roundup_button = (Button) findViewById(R.id.button_roundup);
        change_percentages = (Button) findViewById(R.id.button_changepercentages);

        amount_at_15_textView = (TextView) findViewById(R.id.amount_at_15_textView);
        amount_at_18_textView = (TextView) findViewById(R.id.amount_at_18_textView);
        amount_at_20_textView = (TextView) findViewById(R.id.amount_at_20_textView);
        total_with_15_textView = (TextView) findViewById(R.id.total_with_15);
        total_with_18_textView = (TextView) findViewById(R.id.total_with_18);
        total_with_20_textView = (TextView) findViewById(R.id.total_with_20);


        bill_amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//updates tip amounts and total bill as you enter bill total
            if (!bill_amount.getText().toString().isEmpty()){
                double number = Double.parseDouble(bill_amount.getText().toString());
                StringBuilder percent = new StringBuilder();
                StringBuilder totals = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    switch (i){
                        case 0:
                            ans = MathWorks.round((number * (0.15)), 2);
                            total = MathWorks.round((number + ans),2);
                            percent.append(ans);
                            totals.append(total);
                            amount_at_15_textView.setText(percent);
                            total_with_15_textView.setText(totals);
                            break;
                        case 1:
                            ans = MathWorks.round((number * (0.18)), 2);
                            total = MathWorks.round((number + ans),2);
                            percent.delete(0,percent.length());
                            totals.delete(0,totals.length());
                            percent.append(ans);
                            totals.append(total);
                            amount_at_18_textView.setText(percent);
                            total_with_18_textView.setText(totals);
                            break;
                        case 2:
                            ans = MathWorks.round((number * (0.20)), 2);
                            total = MathWorks.round((number + ans),2);
                            percent.delete(0,percent.length());
                            totals.delete(0,totals.length());
                            percent.append(ans);
                            totals.append(total);
                            amount_at_20_textView.setText(percent);
                            total_with_20_textView.setText(totals);
                            break;
                        default: percent.delete(0,percent.length());
                                 totals.delete(0,totals.length());
                            break;
                    }
                }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        roundup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bill_amount.getText().toString().isEmpty()) {
                    StringBuilder updated_number = new StringBuilder();
                    StringBuilder updated_total = new StringBuilder();
                    double number = 0.0;
                    for (int i = 0; i < 3; i++) {
                        switch (i){
                            case 0:
                                number = Double.parseDouble(amount_at_15_textView.getText().toString());
                                number = Math.ceil(number);
                                updated_number.append(number);
                                amount_at_15_textView.setText(updated_number);
                                total_with_15_textView.setText(updated_total.append((Double.parseDouble(bill_amount.getText().toString()) + number)));
                                break;
                            case 1:
                                number = Double.parseDouble(amount_at_18_textView.getText().toString());
                                number = Math.ceil(number);
                                updated_number.delete(0,updated_number.length());
                                updated_total.delete(0,updated_total.length());
                                updated_number.append(number);
                                amount_at_18_textView.setText(updated_number);
                                total_with_18_textView.setText(updated_total.append((Double.parseDouble(bill_amount.getText().toString()) + number)));
                                break;
                            case 2:
                                number = Double.parseDouble(amount_at_20_textView.getText().toString());
                                number = Math.ceil(number);
                                updated_number.delete(0,updated_number.length());
                                updated_total.delete(0,updated_total.length());
                                updated_number.append(number);
                                amount_at_20_textView.setText(updated_number);
                                total_with_20_textView.setText(updated_total.append((Double.parseDouble(bill_amount.getText().toString()) + number)));
                                break;
                            default:updated_number.delete(0,updated_number.length());
                                break;
                        }

                    }
                }
            }
        });
    }


}
