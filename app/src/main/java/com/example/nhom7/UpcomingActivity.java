package com.example.nhom7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpcomingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private DatabaseReference myRef;
    private ArrayList<Messages> messagesList;
    private RecyclerAdapter recyclerAdapter;
    private Context mcontext;



    ImageView bt1, bt2, bt3, bt4, bt5;
    ListView listView1;
    String mTitle[] = {"SHOPEE LIVE SIÊU SHOW", "11.11 SIÊU SALE CÙNG SIÊU HÀI", "SHOPEE SIÊU RẺ", "SHOPEE SIÊU CHẤT LƯỢNG", "SHOPEE KIDS","SHOPEE LIVE SIÊU SHOW", "11.11 SIÊU SALE CÙNG SIÊU HÀI", "SHOPEE SIÊU RẺ", "SHOPEE SIÊU CHẤT LƯỢNG", "SHOPEE KIDS"};
    String mDescription[] = {"Shopee VN","Shopee VN","Shopee VN","Shopee VN","Shopee VN","Shopee VN","Shopee VN","Shopee VN","Shopee VN","Shopee VN"};
    int inmage[]= {R.drawable.shopee5, R.drawable.shopee6, R.drawable.shopee7, R.drawable.shopee5, R.drawable.shopee6,R.drawable.shopee5, R.drawable.shopee6, R.drawable.shopee7, R.drawable.shopee5, R.drawable.shopee6};
    //so our img and oder  things  are set in array

    // now paste some img int drawable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);




        ///////////////////////
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        myRef = FirebaseDatabase.getInstance().getReference();



        messagesList = new ArrayList<>();


        GetDataFromFirebase();


        ClearAll();

        bt1 = (ImageView) findViewById(R.id.button1);
        bt1 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpcomingActivity.this, Live.class);
                startActivity(intent);
            }
        });
        bt3 = (ImageView) findViewById(R.id.button3);
        bt3 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpcomingActivity.this, IdolActivity.class);
                startActivity(intent);
            }
        });
        bt4 = (ImageView) findViewById(R.id.button4);
        bt4 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpcomingActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });
        bt5 = (ImageView)  findViewById(R.id.button5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpcomingActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        listView1 = findViewById(R.id.lv);
        //now  create an adapter class
        MyAdapter adapter = new MyAdapter( this, mTitle, mDescription, inmage);
        listView1.setAdapter(adapter);



        //nov set item click on this  view
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if( position==0){
                    Toast.makeText(UpcomingActivity.this, "SHOPEE LIVE SIÊU SHOW", Toast.LENGTH_SHORT).show();
                }
                if( position==0){
                    Toast.makeText(UpcomingActivity.this, "11.11 SIÊU SALE CÙNG SIÊU HÀI", Toast.LENGTH_SHORT).show();
                }
                if( position==0){
                    Toast.makeText(UpcomingActivity.this, "SHOPEE SIÊU RẺ", Toast.LENGTH_SHORT).show();
                }
                if( position==0){
                    Toast.makeText(UpcomingActivity.this, "SHOPEE SIÊU CHẤT LƯỢNG", Toast.LENGTH_SHORT).show();
                }
                if( position==0){
                    Toast.makeText(UpcomingActivity.this, "SHOPEE KIDS", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //so item click  is done no check list view
    }



    ////////////////
    private void GetDataFromFirebase() {

        Query query = myRef.child("message");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();
                for(DataSnapshot snapshot : dataSnapshot.getChildren() )
                {
                    Messages messages = new Messages();

                    messages.setImageUrl(snapshot.child("image").getValue().toString());
                    messages.setName(snapshot.child("name").getValue().toString());

                    messagesList.add(messages);

                }

                recyclerAdapter = new RecyclerAdapter(getApplicationContext(),messagesList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void ClearAll() {

        if (messagesList != null){
            messagesList.clear();

            if(recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        messagesList = new ArrayList<>();

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[],String description[], int imgs[]){
            super(c,R.layout.upcoming_row, R.id.textview1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.upcoming_row, parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }

        public MyAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
        }
    }
}