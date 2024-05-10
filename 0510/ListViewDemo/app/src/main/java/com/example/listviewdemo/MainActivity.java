package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lv;
    private  String[] cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = getResources().getStringArray(R.array.cities);
        //lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> a = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,cities);

        lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(a);
        lv.setOnItemClickListener(this);

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView output = (TextView) findViewById(R.id.lblOutput);
//                output.setText("你是住在: " + cities[position]);
//            }
//        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("你是住在: " + cities[position]);
    }
}