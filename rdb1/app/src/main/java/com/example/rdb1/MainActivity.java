package com.example.rdb1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtQuantity = findViewById(R.id.editTextNumberSigned);
        Button button = (Button) findViewById(R.id.button);
        TextView lblOutput = findViewById(R.id.lblOutput);
        TextView lblTotalPrice = findViewById(R.id.lblTotalPrice);

        RadioGroup rgGender = findViewById(R.id.rgGender);
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String gender = radioButton.getText().toString();
                updateOutput(lblOutput, gender);
            }
        });

        RadioGroup rgType = findViewById(R.id.rgType);
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String ticketType = radioButton.getText().toString();
                updateOutput(lblOutput, ticketType);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String outputStr = "";
                int totalPrice = 0;
                RadioButton rdbBoy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton rdbGirl = (RadioButton) findViewById(R.id.rdbGirl);
                if(rdbBoy.isChecked())
                    outputStr += getResources().getString(R.string.male) + "\n";
                else if(rdbGirl.isChecked())
                    outputStr += getResources().getString(R.string.female) + "\n";

                RadioGroup rgType = (RadioGroup) findViewById(R.id.rgType);
                int ticketPrice = 0;
                if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    outputStr += getResources().getString(R.string.regularticket) + "\n";
                    ticketPrice = 500;
                }
                else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild) {
                    outputStr += getResources().getString(R.string.childticket) + "\n";
                    ticketPrice = 400;
                }
                else {
                    outputStr += getResources().getString(R.string.studentticket) + "\n";
                    ticketPrice = 250;
                }

                String quantityStr = edtQuantity.getText().toString();
                if (!quantityStr.isEmpty()) {
                    int quantity = Integer.parseInt(quantityStr);
                    totalPrice = ticketPrice * quantity;
                    outputStr += "Quantity: " + quantity + "\n";
                }

                TextView lblOutput = (TextView) findViewById(R.id.lblOutput);
                lblOutput.setText(outputStr);

                TextView lblTotalPrice = findViewById(R.id.lblTotalPrice);
                lblTotalPrice.setText("價格:$"+ totalPrice);

            }
        });
    }
    private void updateOutput(TextView lblOutput, String text) {
        String currentText = lblOutput.getText().toString();
        String newText = currentText.substring(0, currentText.indexOf("\n")) + "\n" + text + "\n";
        lblOutput.setText(newText);
    }
}