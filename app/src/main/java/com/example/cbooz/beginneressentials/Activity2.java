package com.example.cbooz.beginneressentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle b = getIntent().getExtras();
        String textThatWasSent = b.getString("textToSendKey");

        TextView view = (TextView)findViewById(R.id.ArgumentTextView);
        view.setText(textThatWasSent);
    }
}
