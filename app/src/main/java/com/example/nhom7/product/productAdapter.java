package com.example.nhom7.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhom7.R;

import java.util.ArrayList;

public class productAdapter extends BaseAdapter {
    Context context;
    ArrayList<productModel> productsData;
    LayoutInflater layoutInflater;
    productModel productModel;

    public productAdapter(Context context, ArrayList<productModel> productData) {
        this.context = context;
        this.productsData = productData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return productsData.size();
    }

    @Override
    public Object getItem(int i) {
        return productsData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return productsData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View view1 = view;
        if (view1==null) {
            view1 = layoutInflater.inflate(R.layout.card_item,null, true);
        }
        //getting view in row_data
        TextView name = view1.findViewById(R.id.idttchinh);
        ImageView image = view1.findViewById(R.id.imageView);
        TextView gia = view1.findViewById(R.id.idgia);

        productModel = productsData.get(position);

        name.setText(productModel.getNamedh());
        image.setImageResource(productModel.getImages());
        gia.setText(productModel.getGiadh());
        return view1;
    }
}
