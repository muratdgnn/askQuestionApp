package com.example.projj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class profileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Profile");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        login caller = new login();
        String text = caller.getUsername();
        TextView txt = findViewById(R.id.textView3);
        txt.setText(text);
    }
}