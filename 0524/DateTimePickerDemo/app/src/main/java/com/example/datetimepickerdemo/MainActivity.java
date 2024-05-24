package com.example.datetimepickerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener {


    private TextView txvOutput;

    private Calendar dt = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvOutput = (TextView) findViewById(R.id.txvOutput);

        Button btnDate = (Button) findViewById(R.id.btnDate);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dlg = new DatePickerDialog(MainActivity.this,
                        MainActivity.this,
                        dt.get(Calendar.YEAR),
                        dt.get(Calendar.MONTH),
                        dt.get(Calendar.DAY_OF_MONTH));
                        dt.add(Calendar.DAY_OF_MONTH, 1);
                dlg.getDatePicker().setMinDate(dt.getTimeInMillis());
                dlg.show();
            }
        });

        Button btnTime = (Button) findViewById(R.id.btnTime);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dlg = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                txvOutput.setText("時間: " + hourOfDay + ":" + minute);
                            }
                        },
                        dt.get(Calendar.HOUR),
                        dt.get(Calendar.MINUTE), true);
                dlg.show();
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            txvOutput.setText("日期: " + year + "/" + (month+1) + "/" + dayOfMonth);
    }
}