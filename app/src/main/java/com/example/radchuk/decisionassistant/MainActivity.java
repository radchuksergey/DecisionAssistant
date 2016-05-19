package com.example.radchuk.decisionassistant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText firstOptionEditText = null;
    EditText secondOptionEditText = null;
    Button chooseButtion = null;
    TextView resultTextView = null;
    View.OnClickListener buttonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buttonClick();
        }
    };

    private void buttonClick(){
        if (getSecondOptionsProbability() <= 50) resultTextView.setText(firstOptionEditText.getText().toString());
        else resultTextView.setText(secondOptionEditText.getText().toString());
        firstOptionEditText.setText("");
        secondOptionEditText.setText("");
    }


    private int getSecondOptionsProbability(){
        Double pr = 0.0;
        for (int i = 0; i < 200; i++){
           pr = pr + Math.random();
        }
        pr = pr/200;
        pr = pr * 100;
        return (int) Math.round(pr);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

    }

    private void initUI(){
        firstOptionEditText =(EditText )findViewById(R.id.firstOptionEditText);
        secondOptionEditText =(EditText )findViewById(R.id.secondOptionEditText);
        chooseButtion = (Button)findViewById(R.id.buttonChoose) ;
        resultTextView = (TextView )findViewById(R.id.resultedTextView);
        chooseButtion.setOnClickListener(buttonOnClickListener);
    }


    @Override
    protected void onDestroy() {
        moveTaskToBack(true);

        super.onDestroy();

        finish();
        System.exit(0);

    }
}
