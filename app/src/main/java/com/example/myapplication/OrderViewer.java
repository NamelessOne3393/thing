package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_viewer);
        ImageButton b = findViewById(R.id.imageButton);
        b.setOnClickListener(view -> {
            finish();
        });
        Intent intent = getIntent();

        orderHistoryItem aaaaa = new orderHistoryItem((getResources().getStringArray(R.array.orders))[intent.getExtras().getInt("Id")]);
        TextView buyer = findViewById(R.id.Buyer);
        buyer.setText(aaaaa.getBuyer());
        TextView seller = findViewById(R.id.Seller);
        seller.setText(aaaaa.getSeller());
        TextView total = findViewById(R.id.Total);
        total.setText(aaaaa.getTotal());
        TextView date = findViewById(R.id.date);
        date.setText(aaaaa.getDay());
        TextView iiii = findViewById(R.id.OrderId);
        iiii.setText(aaaaa.getId());
        TextView items = findViewById(R.id.Items);
        items.setText(aaaaa.getItems());
        Toast.makeText(this,aaaaa.getTemp()[0],Toast.LENGTH_LONG).show();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}