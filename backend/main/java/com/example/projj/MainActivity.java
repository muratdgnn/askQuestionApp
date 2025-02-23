package com.example.projj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("SuASK");
        questionList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questionList);

        ListView requestList = findViewById(R.id.questionListView);
        Button addButton = findViewById(R.id.addButton);

        requestList.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, addQuestionActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        // Add some random questions
        questionList.add(new Question("Ali", "HELP CS310"));
        questionList.add(new Question("Mehmet", "HELP for project"));
        adapter.notifyDataSetChanged();

        requestList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Question clickedQuest = questionList.get(position);

                Intent i = new Intent(MainActivity.this, detailsActivity.class);
                i.putExtra("name", clickedQuest.getName());
                i.putExtra("question",clickedQuest.getText());
                startActivity(i);
            }
        });
    }

    // Handle the result from the AddQuestionActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            String question = data.getStringExtra("question");

            Question item = new Question(name,question);
            questionList.add(item);
            adapter.notifyDataSetChanged();
        }
    }

    private ArrayList<Question> questionList;
    private ArrayAdapter<Question> adapter;
}