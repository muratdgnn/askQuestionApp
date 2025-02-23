package com.example.projj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        final EditText nameEditText = findViewById(R.id.NameEditText);
        final EditText questionEditText = findViewById(R.id.questionEditText);
        Button confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String question = questionEditText.getText().toString();

                if(!name.isEmpty() && !question.isEmpty())
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("name",name);
                    resultIntent.putExtra("question",question);
                    setResult(RESULT_OK,resultIntent);
                    finish();
                }
                else{
                    Toast.makeText(addQuestion.this,"enter name and question",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}