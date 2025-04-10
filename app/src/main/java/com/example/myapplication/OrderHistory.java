package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderHistory extends AppCompatActivity {


    private static Map<Integer, String> theList = new HashMap<>();
    private static Integer ARGH = 0;

    ArrayList<orderHistoryItem> thing = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.order_history);

        RecyclerView m = (RecyclerView) findViewById(R.id.MainList);
        setUpModels();
        m.setLayoutManager(new LinearLayoutManager(this));
        m.setAdapter(new histAdapter(this,thing));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setUpModels(){
        for (Integer item : theList.keySet()){
            thing.add(new orderHistoryItem(theList.get(item)));
        }
    }

    public static void checkOut(){
        String toSaveThing = "%d , %d ,Me,You, %.2f ,";
        toSaveThing = String.format(toSaveThing,ARGH,(new Date()).getTime(),ShoppingCart.getTotal());
        for (String item : ShoppingCart.getItemNames())
        {
            toSaveThing += item +":"+ShoppingCart.getQuantity(item)+":"+String.format("%.2f",ShoppingCart.getPrice(item));
        }
        theList.put(ARGH,toSaveThing);
        ARGH +=1;
    }
    public static String getOrder(Integer i){
        return theList.get(i);

    }




}

