package com.example.nhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class IdolActivity extends AppCompatActivity {
    ImageButton bt1, bt2, bt3, bt4, bt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idol);
        bt2 = (ImageButton)  findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdolActivity.this, UpcomingActivity.class);
                startActivity(intent);
            }
        });
        bt1 = (ImageButton)  findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdolActivity.this, Live.class);
                startActivity(intent);
            }
        });
        bt4 = (ImageButton)  findViewById(R.id.button4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdolActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });
        bt5 = (ImageButton)  findViewById(R.id.button5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdolActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}