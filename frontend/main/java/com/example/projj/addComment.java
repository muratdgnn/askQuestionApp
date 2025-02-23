package com.example.projj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class addComment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("SU Ask");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);

        final TextView commname = findViewById(R.id.writeName);
        final TextView commm = findViewById(R.id.writeComment);
        Button add = findViewById(R.id.adddComment);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name5 = commname.getText().toString();
                String comment2 = commm.getText().toString();

                if(!name5.isEmpty() && !comment2.isEmpty())
                {
                    Intent i = new Intent();
                    i.putExtra("name",name5);
                    i.putExtra("comm",comment2);
                    setResult(RESULT_OK,i);
                    finish();
                }
            }
        });

    }
}