package com.example.dd.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Date_Cards extends AppCompatActivity {
    //Создаем поле recyclerView на content_main.xml
    RecyclerView recyclerView;

    //Создаем Адаптер для recyclerView
    MyAdapter myAdapter;

    //Создаем список
    List<Product> productList = new ArrayList<>();


    //Создаем переменные
    List<String> arrayNumbers;
    List<String> arrayEvents;
    List<String> arrayDates;
    List<String> arrayName;
    List<String> arrayPlace;

    //Создаем объект Images
    Images images = new Images();

    //Создаем динамический массив с типом Integer и добавляем туда картинки из Ресурсов
    ArrayList<Integer> imagesArray = images.getArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_cards);

        //Находим recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewList);

        //Создаем и инициализируем recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //Для recyclerView устанавливаем LayoutManager
        recyclerView.setLayoutManager(linearLayoutManager);

        //Вызываем данный метод для добавления данных в массив 
        setInitialData1();

        //инициализируем адаптер для recyclerView
        myAdapter = new MyAdapter(this, productList);

        //устанавливаем для recycleview адаптер
        recyclerView.setAdapter(myAdapter);

        //находим все компоненты
        arrayNumbers = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.arrayNumbers)));
        arrayEvents = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.arrayEvents)));
        arrayDates = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.arrayDates)));
        arrayName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.arrayName)));
        arrayPlace = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.arrayPlace)));
    }

    private void setInitialData1() {

        //Очищаем список
        productList.clear();

        // создаем цикл для добавления инфо в карточки
        for (int i = 0; i < arrayNumbers.size(); i++) {
                //добавляем в список productList новый объект Product с параметрами
                productList.add(new Product(arrayName.get(i), arrayDates.get(i), arrayEvents.get(i), imagesArray.get(i)));
        }
        // обновляем список чтоб показалась новая инфо
        myAdapter.notifyDataSetChanged();
    }
}
