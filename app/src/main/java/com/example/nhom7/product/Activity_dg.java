package com.example.nhom7.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nhom7.R;

public class Activity_dg extends AppCompatActivity {
    ImageButton bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dg);
        bt1 = (ImageButton)  findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_dg.this, Myaccount.class);
                startActivity(intent);
            }
        });
    }
}