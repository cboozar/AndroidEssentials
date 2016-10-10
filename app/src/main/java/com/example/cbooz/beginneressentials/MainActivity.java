package com.example.cbooz.beginneressentials;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets Counter Button to value set in memory on App Load
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        int counter = sharedPreferences.getInt("counterKey", 0);
        ((Button)findViewById(R.id.CounterButton)).setText("Counter: " + counter);
    }

    public void StartActivity2Click(View view) {
        EditText edit = (EditText) findViewById(R.id.ArgEditText);
        String textToSend = edit.getText().toString();
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("textToSendKey", textToSend);
        startActivity(intent);
    }

    public void CounterButtonClick(View view) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE); //Only this app can access these preferences
        int counter = sharedPreferences.getInt("counterKey", 0);                    //Only set to 0 on initial App start
        counter++;                                                                  //Increment Counter (only on this button click)
        ((Button)view).setText("Counter: " + counter);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("counterKey", counter);
        editor.apply();
    }
}
