package com.example.explicitintdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.RadioButton;

public class OpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);
        CheckBox chkDivide =  (CheckBox) findViewById(R.id.chkDivide);;
        chkDivide.setEnabled(false);



        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opd1, opd2;
                double result =0.0;
                RadioButton rdbAdd, rdbSubtract, rdbMultipy, rdbDivide;


                Bundle bundle = OpActivity.this.getIntent().getExtras();
                if(bundle == null)return;

                opd1 = Integer.parseInt(bundle.getString("OPERAND01"));
                opd2 = Integer.parseInt(bundle.getString("OPERAND02"));

                rdbAdd = (RadioButton) findViewById(R.id.rdbAdd);
                if(rdbAdd.isChecked()){
                    chkDivide.setEnabled(false);
                    result = opd1 + opd2;
                }
                rdbSubtract = (RadioButton) findViewById(R.id.rdbSubtract);
                if(rdbSubtract.isChecked()){
                    chkDivide.setEnabled(false);
                    result = opd1 - opd2;
                }
                rdbMultipy = (RadioButton) findViewById(R.id.rdbMultiply);
                if(rdbMultipy.isChecked()){
                    chkDivide.setEnabled(false);
                    result = opd1 * opd2;
                }
                rdbDivide = (RadioButton) findViewById(R.id.rdbDivide);
                //chkDivide =
                if(rdbDivide.isChecked()){
                    chkDivide.setEnabled(true);
                    if(chkDivide.isChecked())
                        result = opd1 / opd2;
                    else
                        result = opd1 / (double) opd2;

                }
                Intent rIntent = new Intent();

                Bundle rbundle = new Bundle();
                rbundle.putDouble("RESULT", result);
                rIntent.putExtras(rbundle);
                setResult(RESULT_OK, rIntent);
                finish();
            }
        });
    }
}