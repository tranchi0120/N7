package com.example.nhom7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.nhom7.product.Myaccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Feedback extends AppCompatActivity {

    ImageButton bt1, bt2, bt3, bt4, bt5, bt6, bt7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        bt6 = (ImageButton)  findViewById(R.id.button7);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feedback.this, MessengerActivity.class);
                startActivity(intent);
            }
        });
        bt7 = (ImageButton)  findViewById(R.id.button6);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feedback.this, BasketActivity.class);
                startActivity(intent);
            }
        });

        bt2 = (ImageButton)  findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feedback.this, LoginMainActivity.class);
                startActivity(intent);
            }
        });
        bt3 = (ImageButton)  findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feedback.this, MainAction.class);
                startActivity(intent);
            }
        });
        bt4 = (ImageButton)  findViewById(R.id.bt4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feedback.this,Geography.class);
                startActivity(intent);
            }
        });
        bt5 = (ImageButton)  findViewById(R.id.bt5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feedback.this, History.class);
                startActivity(intent);
            }
        });

        //BottomNavigation di chuyển giữa các layout
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.feed);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.feed:

                        return true;
                    case R.id.live:
                        startActivity(new Intent(getApplicationContext(), Live.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.notification:
                        startActivity(new Intent(getApplicationContext(), Notification.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.myaccount:
                        startActivity(new Intent(getApplicationContext(), Myaccount.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),
                                Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}