package com.example.nhom7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class LoginMainActivity  extends AppCompatActivity {

    ImageButton bt1, bt2, bt3, bt4, bt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_main);

        bt3 = (ImageButton)  findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.nhom7.LoginMainActivity.this, com.example.nhom7.MainAction.class);
                startActivity(intent);
            }
        });
        bt4 = (ImageButton)  findViewById(R.id.bt4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.nhom7.LoginMainActivity.this, com.example.nhom7.Geography.class);
                startActivity(intent);
            }
        });
        bt5 = (ImageButton)  findViewById(R.id.bt5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.nhom7.LoginMainActivity.this, com.example.nhom7.History.class);
                startActivity(intent);
            }
        });
        bt1 = (ImageButton)  findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.nhom7.LoginMainActivity.this, Feedback.class);
                startActivity(intent);
            }
        });
    }
    }