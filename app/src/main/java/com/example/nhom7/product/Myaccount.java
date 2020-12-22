package com.example.nhom7.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhom7.Activity_Sale;
import com.example.nhom7.BasketActivity;
import com.example.nhom7.Feedback;
import com.example.nhom7.Home;
import com.example.nhom7.Live;
import com.example.nhom7.LoginActivity;
import com.example.nhom7.MapsActivity;
import com.example.nhom7.MessengerActivity;
import com.example.nhom7.Notification;
import com.example.nhom7.QrActivity;
import com.example.nhom7.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Myaccount extends AppCompatActivity {
    TextView t1, t2;
    ImageButton bt6, bt7,bt1,bt2,bt3,bt4,bt10,bt11,bt12,bt13;
    ListView listViewshopee;
    ListAccountAdapter adapter;
    ArrayList<ListAccount> arr_bean_shopee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);

        bt6 = (ImageButton)  findViewById(R.id.button7);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, MessengerActivity.class);
                startActivity(intent);
            }
        });
        bt7 = (ImageButton)  findViewById(R.id.button6);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, BasketActivity.class);
                startActivity(intent);
            }
        });
        bt1 = (ImageButton)  findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, Home.class);
                startActivity(intent);
            }
        });
        bt2 = (ImageButton)  findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, Activity_voucher.class);
                startActivity(intent);
            }
        });
        bt3 = (ImageButton)  findViewById(R.id.button3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, BasketActivity.class);
                startActivity(intent);
            }
        });
        bt4 = (ImageButton)  findViewById(R.id.button4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, Activity_Sale.class);
                startActivity(intent);
            }
        });
        bt10 = (ImageButton)  findViewById(R.id.button10);
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, BasketActivity.class);
                startActivity(intent);
            }
        });
        bt11 = (ImageButton)  findViewById(R.id.button11);
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, BasketActivity.class);
                startActivity(intent);
            }
        });
        bt12 = (ImageButton)  findViewById(R.id.button12);
        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, BasketActivity.class);
                startActivity(intent);
            }
        });
        bt13 = (ImageButton)  findViewById(R.id.button13);
        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myaccount.this, Activity_dg.class);
                startActivity(intent);
            }
        });
        listViewshopee  = (ListView)findViewById(R.id.listviewCauthu);

        arr_bean_shopee = new ArrayList<ListAccount>();
        arr_bean_shopee.add(new ListAccount(R.drawable.vi, "Ví Shopee"));
        arr_bean_shopee.add(new ListAccount(R.drawable.vi_air, "Ví AirPay"));
        arr_bean_shopee.add(new ListAccount(R.drawable.shopeexu, "Shopee Xu"));
        arr_bean_shopee.add(new ListAccount(R.drawable.danhgia1, "Đánh giá của tôi"));
        arr_bean_shopee.add(new ListAccount(R.drawable.vi_voucher, "Ví voucher"));
        arr_bean_shopee.add(new ListAccount(R.drawable.qr, "Quét mã QR"));
        arr_bean_shopee.add(new ListAccount(R.drawable.trungtamtrogiup, "Vị trí của tôi"));
        arr_bean_shopee.add(new ListAccount(R.drawable.ic_account, "Đăng xuất"));
        adapter = new ListAccountAdapter(arr_bean_shopee, this);
        listViewshopee.setAdapter(adapter);
        listViewshopee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Activity_vi.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent1 = new Intent(view.getContext(), Activity_via.class);
                    startActivity(intent1);
                }
                if (position == 2) {
                    Intent intent2 = new Intent(view.getContext(), Activity_xu.class);
                    startActivity(intent2);
                }
                if (position == 3) {
                    Intent intent3 = new Intent(view.getContext(), Activity_dg.class);
                    startActivity(intent3);
                }
                if (position == 4) {
                    Intent intent4 = new Intent(view.getContext(), Activity_voucher.class);
                    startActivity(intent4);
                }
                if (position == 5) {
                    Intent intent5 = new Intent(view.getContext(), QrActivity.class);
                    startActivity(intent5);
                }
                if (position == 6) {
                    Intent intent6 = new Intent(view.getContext(), MapsActivity.class);
                    startActivity(intent6);
                }
                if (position == 7) {
                    Intent intent7 = new Intent(view.getContext(), LoginActivity.class);
                    startActivity(intent7);
                }
            }
        });


    //Đang hiển thị 5637687004445961448.
        //BottomNavigation di chuyển giữa các layout
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.myaccount);
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
                        startActivity(new Intent(getApplicationContext(), Notification.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.myaccount:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}