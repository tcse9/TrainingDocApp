package com.example.trainingdocapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private AppCompatButton btnDrag;
    private AppCompatButton btnTalkBubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDrag = findViewById(R.id.btnDrag);
        btnTalkBubble = findViewById(R.id.btnTalkBubble);


        btnDrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DragDropActivity.class);
                startActivity(intent);
            }
        });



        btnTalkBubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TalkBubbleActivity.class);
                startActivity(intent);
            }
        });
    }
}
