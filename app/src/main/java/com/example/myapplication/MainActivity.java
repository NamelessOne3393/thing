package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FarmData.initilizeFarms();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button exploreFarmsButton = findViewById(R.id.exploreFarmsButton);
        Button viewMapButton = findViewById(R.id.viewMapButton);


        exploreFarmsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExploreFarmsActivity.class);
            startActivity(intent);
        });

        viewMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        Button viewCartButton = findViewById(R.id.cartButton);
        viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void openLocalRoots(View view) {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }


    public void openOrderHistory(View view) {
        Intent intent = new Intent(this, OrderHistory.class);
        startActivity(intent);
    }
}

