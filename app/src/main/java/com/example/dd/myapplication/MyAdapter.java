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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //Создали объект Context
    Context context;

    //Создали массив с типом Product
    List<Product> productList = new ArrayList<>();

    //Создаем конструктор с 2 параметрами: объект Context, Коллекция с типом Product
    public MyAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    //Создаем метод ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Создаем объект View в который передаем Inflater
        View view = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
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

    //Данный класс ViewHolder используем для меню 2 и меню 3
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        TextView mTextView2;
        TextView mTextView3;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.mTextView = (TextView) itemView.findViewById(R.id.textView);
            this.mTextView2 = (TextView) itemView.findViewById(R.id.tv_dateItems);
            this.mTextView3 = (TextView) itemView.findViewById(R.id.tv_eventPlaceItems);
        }
    }
}
