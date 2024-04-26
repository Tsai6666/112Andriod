package com.example.ch5_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.ch5_4.R;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private TextView txvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvOutput = (TextView) findViewById(R.id.txvOutput);
        txvOutput.setTextSize(25);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activity_main);
        layout.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int act = event.getAction();
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        switch (act){
            case MotionEvent.ACTION_DOWN:
                txvOutput.setText("ACTION_DOWN");
                txvOutput.setTextColor(Color.RED);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vb.vibrate(VibrationEffect.createOneShot(2000,20));
                }
                break;
            case MotionEvent.ACTION_UP:
                txvOutput.setText("ACTION_UP");
                txvOutput.setTextColor(Color.GREEN);
                break;
            case  MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                txvOutput.setText("X = "+ x + "\nY = " +y);
                txvOutput.setTextColor(Color.BLUE);
                break;

        }


        return false;
    }
}