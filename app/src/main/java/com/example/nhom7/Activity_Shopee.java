package com.example.nhom7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_Shopee extends AppCompatActivity {
    ImageButton bt1;
    ListView listView;
    Context context;
    ArrayList<CountriesModel> countriesData;
    CustomAdapter customAdapter;
    CountriesModel countriesModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity__shopee);
        bt1 = (ImageButton)  findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Shopee.this, Notification.class);
                startActivity(intent);
            }
        });

        //getviews
        listView = findViewById(R.id.listView);
        countriesData = new ArrayList<>();

        //add Countries Data
        populateCountriesData();

        customAdapter = new CustomAdapter(context,countriesData);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,countriesData.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void populateCountriesData() {

        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setName("Bài đăng của Shoppe vn");
        countriesModel.setImage(R.drawable.h10);
        countriesModel.setArea("⏱ 20:02 14-11-20");
        countriesModel.setPopulation("☎ ADIDAS Bùng nổ ưu đãi CƠ HỘI CUỐI CÙNG HÔM NAY.....");
        countriesData.add(countriesModel);


        countriesModel = new CountriesModel();
        countriesModel.setId(2);
        countriesModel.setName("Xem video trực tiếp ");
        countriesModel.setImage(R.drawable.h10);
        countriesModel.setArea("⏱ 11:51 14-11-20");
        countriesModel.setPopulation("🎆 STRAY KIDS SHOPEE");
        countriesData.add(countriesModel);


        countriesModel = new CountriesModel();
        countriesModel.setId(3);
        countriesModel.setName("Xem video trực tiếp");
        countriesModel.setImage(R.drawable.h10);
        countriesModel.setArea("⏱ 11:41 13-11-20");
        countriesModel.setPopulation("🥓 SIÊU SALE CÙNG SIÊU HÀI");
        countriesData.add(countriesModel);


        countriesModel = new CountriesModel();
        countriesModel.setId(4);
        countriesModel.setName("Xem bài đăng của shopee ");
        countriesModel.setImage(R.drawable.h10);
        countriesModel.setArea("⏱ 00:32 14-11-20");
        countriesModel.setPopulation("🚵‍♂ ĐÓN CHỜ BÁY LÂU - BẮT.....");
        countriesData.add(countriesModel);

        countriesModel = new CountriesModel();
        countriesModel.setId(5);
        countriesModel.setName("#Xem bài đăng của shopee  ");
        countriesModel.setImage(R.drawable.h10);
        countriesModel.setArea("⏱ 08:47 13-11-20");
        countriesModel.setPopulation("💢 Đêm tiệc Livestream không.....");
        countriesData.add(countriesModel);

        countriesModel = new CountriesModel();
        countriesModel.setId(3);
        countriesModel.setName("Xem video trực tiếp");
        countriesModel.setImage(R.drawable.h10);
        countriesModel.setArea("⏱ 11:41 13-11-20");
        countriesModel.setPopulation("🥓 SIÊU SALE CÙNG SIÊU HÀI");

        countriesModel = new CountriesModel();
        countriesModel.setId(3);
        countriesModel.setName("Xem video trực tiếp");
        countriesModel.setImage(R.drawable.h10);
        countriesModel.setArea("⏱ 11:41 13-11-20");
        countriesModel.setPopulation("🥓 SIÊU SALE CÙNG SIÊU HÀI");
        countriesData.add(countriesModel);


    }
}