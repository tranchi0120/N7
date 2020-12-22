package com.example.nhom7;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhom7.product.Myaccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {
ImageButton bt6,bt7;
    ListView listViewshopee;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean_shopee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        bt6 = (ImageButton)  findViewById(R.id.button7);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notification.this, MessengerActivity.class);
                startActivity(intent);
            }
        });
        bt7 = (ImageButton)  findViewById(R.id.button6);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notification.this, BasketActivity.class);
                startActivity(intent);
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.notification);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.feed:
                        startActivity(new Intent(getApplicationContext(), Feedback.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.live:
                        startActivity(new Intent(getApplicationContext(), Live.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.notification:

                        return true;
                    case R.id.myaccount:
                        startActivity(new Intent(getApplicationContext(), Myaccount.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        listViewshopee = (ListView) findViewById(R.id.listviewCauthu);

        arr_bean_shopee = new ArrayList<ListViewBean>();
        arr_bean_shopee.add(new ListViewBean(R.drawable.capnhat, " Khuyến mãi "));
        arr_bean_shopee.add(new ListViewBean(R.drawable.shopeelive, " Shopee Live & Feed"));
        arr_bean_shopee.add(new ListViewBean(R.drawable.activity, " Hoạt động"));
        arr_bean_shopee.add(new ListViewBean(R.drawable.capnhat, " Cập nhật Shoppe"));
        arr_bean_shopee.add(new ListViewBean(R.drawable.nowfood, " NowFood"));
        adapter = new ListViewBaseAdapter(arr_bean_shopee, this);
        listViewshopee.setAdapter(adapter);
        listViewshopee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Activity_Hd.class);
                    startActivity(intent);
                }
                if (position == 0) {
                    Intent intent1 = new Intent(view.getContext(), Activity_Sale.class);
                    startActivity(intent1);
                }
                if (position == 1) {
                    Intent intent2 = new Intent(view.getContext(), Activity_Shopee.class);
                    startActivity(intent2);
                }
                if (position == 3) {
                    Intent intent3 = new Intent(view.getContext(), Activity_cn.class);
                    startActivity(intent3);
                }
                if (position == 4) {
                    Intent intent4 = new Intent(view.getContext(), Activity_Now.class);
                    startActivity(intent4);
                }
            }
        });



    }
}