package com.example.dd.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Type_ListItems extends AppCompatActivity implements AdapterView.OnItemClickListener {


    //находим listview который создали
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        //Создаем адаптер и присваем ему массив из ресурсов arrayString
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.eventTypes));

        //находим ListView из layout
        listView = (ListView) findViewById(R.id.listView2);

        //присваем listview адаптер
        listView.setAdapter(arrayAdapter);

        //при клике на каждый пункт в listview событие будет обрабатываться
        listView.setOnItemClickListener(this);
    }

    //здесь будет обрабываться клик по пунктам в listview
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //создали intent и который пернаправляет на класс Type_Cards
        Intent intentNumbers = new Intent(getApplicationContext(), Type_Cards.class);

//        Положили в intent текущую позиция пункта на который кликнули
        intentNumbers.putExtra("position", String.valueOf(position));

//        открыли новый activity
        startActivity(intentNumbers);

    }
}
