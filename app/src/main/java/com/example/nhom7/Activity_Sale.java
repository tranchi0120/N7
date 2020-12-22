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

public class Activity_Sale extends AppCompatActivity {
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
        setContentView(R.layout.activity__sale);
        bt1 = (ImageButton)  findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Sale.this, Notification.class);
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
        countriesModel.setName("Xu thưởng Free đợi bạn từ chiều");
        countriesModel.setImage(R.drawable.h5);
        countriesModel.setArea("⏱ 20:02 14-11-20");
        countriesModel.setPopulation("🎁 Vào lấy ngay - 🎶 Đừng để tuột tay");
        countriesData.add(countriesModel);


        countriesModel = new CountriesModel();
        countriesModel.setId(2);
        countriesModel.setName("Loạt đồng hộ Xin chỉ từ 11k");
        countriesModel.setImage(R.drawable.h6);
        countriesModel.setArea("⏱ 11:51 14-11-20");
        countriesModel.setPopulation("🎆 Voucher hoàn đến 150k xu 🎊 Săn deal 11k cực HOT 🐱‍💻 Sản phẩm cháy hàng, vào mua nhanh");
        countriesData.add(countriesModel);


        countriesModel = new CountriesModel();
        countriesModel.setId(3);
        countriesModel.setName("Hàng quốc tế chỉ từ 10k");
        countriesModel.setImage(R.drawable.h7);
        countriesModel.setArea("⏱ 11:41 13-11-20");
        countriesModel.setPopulation("🥓 Giảm toàn bộ đến 50% 🚌 Mua cực thích, vào sắm ngay");
        countriesData.add(countriesModel);


        countriesModel = new CountriesModel();
        countriesModel.setId(4);
        countriesModel.setName("Shopee Games - Chơi vui trúng thưởng ");
        countriesModel.setImage(R.drawable.h9);
        countriesModel.setArea("⏱ 00:32 14-11-20");
        countriesModel.setPopulation("🚵‍♂️ Shopee đập kẹo: x2 lượt đi chuyển kẹo, chỉ 400 xu thêm 10 lượt di chuyển 🎢 Shopee bắn bong bóng. Tăng lượt chia sẻ mỗi ngày 🧧 Nông trại Shopee: Giảm 50% - bình thần kì 🛒 Thử thách phi dao: Voucher hoàn xu 411k ");
        countriesData.add(countriesModel);

        countriesModel = new CountriesModel();
        countriesModel.setId(5);
        countriesModel.setName("#11.11 đã qua nhưng Freeship  ");
        countriesModel.setImage(R.drawable.h8);
        countriesModel.setArea("⏱ 08:47 13-11-20");
        countriesModel.setPopulation("💢 9h - Mở cửa đón Freeship 0đ 🚫 Vào ngay dừng để Freeship bay mất");
        countriesData.add(countriesModel);


    }
}