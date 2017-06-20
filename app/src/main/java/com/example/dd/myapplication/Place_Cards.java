package com.example.dd.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dd on 16.06.2017.
 */

public class Place_Cards extends AppCompatActivity {

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

    Images images = new Images();
    ArrayList<Integer> imagesArray = images.getArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards);

        //Находим recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewList);

        //Создаем и инициализируем recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //Для recyclerView устанавливаем LayoutManager
        recyclerView.setLayoutManager(linearLayoutManager);

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





        //создаю intent чтобы получить данные с предыдущего activity
        //в данном случае присылается пункт на который был кликнут. ключь = "position"
        Intent intent = getIntent();

        //создаю переменную чтоб туда записывалась position clicked от предыдущего activity по ключю = "position"
        String positionClicked = intent.getStringExtra("position");

        //в массив записываю данные из Ресурсов
        String[] tempType = getResources().getStringArray(R.array.eventPlaces);

        //в метод передаем String с текстом взятым из ресурсов который похожи с названием пункта на который кликнули
        setInitialData1(tempType[Integer.parseInt(positionClicked)]);
    }

    private void setInitialData1(String eventPlace) {
        //Очищаем список
        productList.clear();

        // создаем цикл с фильтром внутри для добавления инфо в карточки
        for (int i = 0; i < arrayNumbers.size(); i++) {
            //фильтруем данные
            if (arrayPlace.get(i).equals(eventPlace)) {
                //добавляем в список productList новый объект Product с параметрами
                productList.add(new Product(arrayName.get(i), arrayDates.get(i), arrayEvents.get(i),imagesArray.get(i)));
            }
        }
        // обновляем список чтоб показалась новая инфо
        myAdapter.notifyDataSetChanged();
    }
}
