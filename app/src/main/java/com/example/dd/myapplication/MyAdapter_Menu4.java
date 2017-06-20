package com.example.dd.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dd on 11.06.2017.
 */

public class MyAdapter_Menu4 extends RecyclerView.Adapter<MyAdapter_Menu4.ViewHolder> {

    //Создали объект Context
    Context context;

    //Создали массив с типом Product
    List<Product> productList = new ArrayList<>();

    Integer layout = null;


    //Создаем конструктор с 2 параметрами: объект Context, Коллекция с типом Product,
    // в 3 параметр приходиn название layout
    public MyAdapter_Menu4(Context context, List<Product> productList, Integer layout) {
        this.context = context;
        this.productList = productList;
        this.layout = layout;
    }

    //Создаем метод ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //определяем какий layout использовать
        if (layout != null) {
            layout = R.layout.menu4_date_cards;
        } else layout = R.layout.items;

        //Создаем объект View в который передаем Inflater
        View view = LayoutInflater.from(context).inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.mTextView.setText(product.getText1());
        holder.mTextView2.setText(product.getText2());
        holder.mTextView3.setText(product.getText3());
        holder.mImageView.setImageResource(product.getImage());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    //Данный класс ViewHolder используем для меню 4, потому что у них карточка другая
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        TextView mTextView2;
        TextView mTextView3;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mImageView = (ImageView) itemView.findViewById(R.id.menu4_iv);
            this.mTextView = (TextView) itemView.findViewById(R.id.menu4_tv_dateItems);
            this.mTextView2 = (TextView) itemView.findViewById(R.id.menu4_tv_eventPlaceItems);
            this.mTextView3 = (TextView) itemView.findViewById(R.id.menu4_tv_detailed);
        }
    }
}
