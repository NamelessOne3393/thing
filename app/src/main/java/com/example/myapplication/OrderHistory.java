package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderHistory extends AppCompatActivity {

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
        String[] thingsss =getResources().getStringArray(R.array.orders);


        for (int i = 0; i< thingsss.length; i++ ){
            thing.add(new orderHistoryItem(thingsss[i]));
        }
    }




}

