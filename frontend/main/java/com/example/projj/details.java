package com.example.projj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        commentList = new ArrayList<>();
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,commentList);

        ListView comments = findViewById(R.id.CommentList);
        comments.setAdapter(adapter2);

        Intent i = getIntent();
        String name3 = i.getStringExtra("name");
        String quest = i.getStringExtra("question");

        TextView nameee = findViewById(R.id.namee);
        TextView quest2 = findViewById(R.id.quest3);


        nameee.setText(name3);
        quest2.setText(quest);

        Button back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(details.this,MainActivity.class);
                startActivityForResult(i,1);
            }
        });


        Button confirmComm = findViewById(R.id.addComm);
        confirmComm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(details.this,addComment.class);
                startActivityForResult(i,1);
            }
        });

        comments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Comment clickedComment = commentList.get(position);

                Intent i2 = new Intent(details.this,addComment.class);
                i2.putExtra("name",clickedComment.getName());
                i2.putExtra("comm",clickedComment.getComm());
                startActivity(i2);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode == RESULT_OK && data !=null)
        {
            String name4 = data.getStringExtra("name");
            String comment2 = data.getStringExtra("comm");

            Comment item = new Comment(name4, comment2);
            commentList.add(item);
            adapter2.notifyDataSetChanged();
        }
    }

    private ArrayList<Comment> commentList;
    private ArrayAdapter<Comment> adapter2;
}