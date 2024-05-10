package com.example.arrayadapterspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.security.SecurityPermission;

public class MainActivity extends AppCompatActivity {

    private Spinner drink, temp;
    private TextView txv;

    private String[] tempSet1 = { "冰", "去冰" , "溫"};

    private String[] tempSet2 ={ "冰", "去冰"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView) findViewById(R.id.order);
        temp = (Spinner) findViewById(R.id.temp);

        drink = (Spinner) findViewById(R.id.drink);
        drink.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] tempSet;
                if (position == 3)
                    tempSet = tempSet2;
                else
                    tempSet = tempSet1;

                ArrayAdapter<String >tempAd =
                        new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                tempSet);
                tempAd.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
                temp.setAdapter(tempAd);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button order = (Button) findViewById(R.id.btnOrder);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = drink.getSelectedItem().toString() + ", " +
                        temp.getSelectedItem().toString();
                txv.setText(msg);
            }
        });
    }
}