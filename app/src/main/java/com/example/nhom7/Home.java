package com.example.nhom7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.nhom7.product.Myaccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


import category.Category;
import category.CategoryAdapter;
import shop.Shop;

public class Home extends AppCompatActivity {
    ImageButton bt6,bt7;
    RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    ViewFlipper v_flipper;
    ViewFlipper v_flipper1;
    GridView gridView;
    Context context;
    RelativeLayout gridviewdata;
    ArrayList<ProductModel> productData;
    ProductAdapter productAdapter;
    ProductModel productModel;
    int [] arrayHinh = {R.drawable.f1,R.drawable.f2,R.drawable.f3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_home);
        bt6 = (ImageButton) findViewById(R.id.button7);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MessengerActivity.class);
                startActivity(intent);
            }
        });
        bt7 = (ImageButton)  findViewById(R.id.button6);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, BasketActivity.class);
                startActivity(intent);
            }
        });


        //Viewfliper1
        v_flipper1 = (ViewFlipper) findViewById(R.id.v_flipper1);
        for (int i=0;i<arrayHinh.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP)
            ;
            imageView.setImageResource(arrayHinh[i]);
            v_flipper1.addView(imageView);
        }
        v_flipper1.setFlipInterval(3000);
        v_flipper1.setAutoStart(true);

        //getviews
        gridView = findViewById(R.id.gridview);
        gridviewdata = (RelativeLayout) findViewById(R.id.gridviewdata);
        productData = new ArrayList<>();


        //add Countries Data
        populateProductData();
        productAdapter = new ProductAdapter(context,productData);
        gridView.setAdapter(productAdapter);
        registerForContextMenu(gridView);
        gridView = findViewById(R.id.gridview);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,productData.get(position).getNamedh(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",productData.get(position).getNamedh());
                intent.putExtra("image",productData.get(position).getImages());
                intent.putExtra("gia",productData.get(position).getGiadh());
                startActivity(intent);
            }
        });




        registerForContextMenu(this.gridView);
        //BottomNavigation di chuyển giữa các layout
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.feed:
                        startActivity(new Intent(getApplicationContext(),
                                Feedback.class));
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
                        startActivity(new Intent(getApplicationContext(), Myaccount.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;
                }
                return false;
            }
        });
        rcvCategory= findViewById(R.id.rcv_category);
        categoryAdapter= new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

       //fileper chuyeern trang
        rcvCategory.setAdapter(categoryAdapter);
        int images [] = {R.drawable.bigsale,R.drawable.sh1,R.drawable.shopee21,R.drawable.bigsale,R.drawable.shopee41,R.drawable.sh1};
        v_flipper = findViewById(R.id.v_flipper);
        for (int image: images){
            flipperImages(image);
        }


    }

    private void populateProductData() {
        //product1
        productModel = new ProductModel();
        productModel.setId(1);
        productModel.setNamedh("Shopee");
        productModel.setImages(R.drawable.im);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product2
        productModel = new ProductModel();
        productModel.setId(2);
        productModel.setNamedh("Chăn gối");
        productModel.setImages(R.drawable.im1);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product3
        productModel = new ProductModel();
        productModel.setId(3);
        productModel.setNamedh("lót giày");
        productModel.setImages(R.drawable.im2);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product4
        productModel = new ProductModel();
        productModel.setId(4);
        productModel.setNamedh("các dụng cụ ");
        productModel.setImages(R.drawable.im3);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product5
        productModel = new ProductModel();
        productModel.setId(5);
        productModel.setNamedh("shopee");
        productModel.setImages(R.drawable.im4);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product6
        productModel = new ProductModel();
        productModel.setId(6);
        productModel.setNamedh("shopee");
        productModel.setImages(R.drawable.im5);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product7
        productModel = new ProductModel();
        productModel.setId(7);
        productModel.setNamedh("shopee");
        productModel.setImages(R.drawable.im6);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product8
        productModel = new ProductModel();
        productModel.setId(8);
        productModel.setNamedh("shopee");
        productModel.setImages(R.drawable.im7);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product9
        productModel = new ProductModel();
        productModel.setId(9);
        productModel.setNamedh("shopee");
        productModel.setImages(R.drawable.im8);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product10
        productModel = new ProductModel();
        productModel.setId(10);
        productModel.setNamedh("shopee");
        productModel.setImages(R.drawable.im9);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);


        //product11
        productModel = new ProductModel();
        productModel.setId(11);
        productModel.setNamedh("shopee");
        productModel.setImages(R.drawable.im5);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);


        //product12
        productModel = new ProductModel();
        productModel.setId(12);
        productModel.setNamedh("mat hang");
        productModel.setImages(R.drawable.im6);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product4
        productModel = new ProductModel();
        productModel.setId(13);
        productModel.setNamedh("các dụng cụ ");
        productModel.setImages(R.drawable.im1);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);

        //product5
        productModel = new ProductModel();
        productModel.setId(14);
        productModel.setNamedh("shopee");
        productModel.setImages(R.drawable.im2);
        productModel.setGiadh("3.200VND-4.200VND");
        productData.add(productModel);


    }
    public void flipperImages(int image){
        ImageView imageView =  new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }


    //Recycalview row
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Shop>  listShop = new ArrayList<>();
        List<Shop>  listShop1 = new ArrayList<>();
        listShop.add(new Shop(R.drawable.r1,"Hoàn xu đơn bất kỳ"));
        listShop.add(new Shop(R.drawable.r2,"NowFood"));
        listShop.add(new Shop(R.drawable.r3,"Hàng quốc tế"));
        listShop.add(new Shop(R.drawable.r4,"Shopee Rewards"));
        listShop.add(new Shop(R.drawable.r5,"khung giờ săn sale"));
        listShop.add(new Shop(R.drawable.r6,"chỉ từ 1k"));
        listShop.add(new Shop(R.drawable.r7,"Free ship extra"));
        listShop.add(new Shop(R.drawable.r10,"khung giờ săn sale"));
        listShop.add(new Shop(R.drawable.r11,"chỉ từ 1k"));
        listShop.add(new Shop(R.drawable.r12,"Free ship extra"));

        listShop1.add(new Shop(R.drawable.r6,"NowFood"));
        listShop1.add(new Shop(R.drawable.r7,"Hoàn xu đơn bất kỳ"));
        listShop1.add(new Shop(R.drawable.r10,"Shopee Rewards"));
        listShop1.add(new Shop(R.drawable.r12,"chỉ từ 1k"));
        listShop1.add(new Shop(R.drawable.r13,"Free ship extra"));
        listShop1.add(new Shop(R.drawable.r14,"khung giờ săn sale"));
        listShop1.add(new Shop(R.drawable.r15,"Hàng quốc tế"));
        listShop1.add(new Shop(R.drawable.r16,"Free ship extra"));
        listShop1.add(new Shop(R.drawable.r17,"khung giờ săn sale"));
        listShop1.add(new Shop(R.drawable.r15,"Hàng quốc tế"));



        listCategory.add(new Category("", listShop));
        listCategory.add(new Category("", listShop1));

        return listCategory;
    }
}


