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

import com.example.nhom7.product.Activity_dg;
import com.example.nhom7.product.Myaccount;

import java.util.ArrayList;

public class Activity_cn extends AppCompatActivity {
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
        setContentView(R.layout.activity_cn);
        bt1 = (ImageButton)  findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_cn.this, Notification.class);
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
        countriesModel.setName("Mua đúng đơn - Nhận đúng h..");
        countriesModel.setImage(R.drawable.h11);
        countriesModel.setArea("⏱ 20:02 14-11-20");
        countriesModel.setPopulation("🎁 Tham gia chiến dịc nói KHÔNG với LỪA ĐẢO cùng bí quyết 🏓 KHÔNG nhận hàng có mã đơn lạ. 🎁 KHÔNG nhận quà không rõ chương trình hoạc có thu thêm phí!! Kiểm tra và chỉ nhận hàng CÓ mã đơn trùng với mã đơn đã đặt trên hệ thống Shopee!! Kiểm tra và nhận quà từ chương trình mà bạn CÓ tham gia." +
                "Mọi thắc mắc hãy gọi ngay đến tổng đài của Shopee 19001221. Bấm để xem ngay bí quyết kiểm tra đơn hàng đúng, nhận hàng chuẩn");
        countriesData.add(countriesModel);


        countriesModel = new CountriesModel();
        countriesModel.setId(2);
        countriesModel.setName("Loạt đồng hộ Xin chỉ từ 11k");
        countriesModel.setImage(R.drawable.h6);
        countriesModel.setArea("⏱ 11:51 14-11-20");
        countriesModel.setPopulation("🎆 Voucher hoàn đến 150k xu 🎊 Săn deal 11k cực HOT 🚫 Sản phẩm cháy hàng, vào mua nhanh");
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