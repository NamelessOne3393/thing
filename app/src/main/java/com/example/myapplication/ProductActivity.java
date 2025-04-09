package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this,"I AM ALIVE!",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // Set up product information
        TextView productName = findViewById(R.id.product_name);
        TextView productPrice = findViewById(R.id.product_price);
        ImageView productImage = findViewById(R.id.product_image);

        // Setting product details
        productName.setText("Cucumber");
        productPrice.setText("Price - 99$");
        productImage.setImageResource(R.drawable.cucumber);

        // Add to wishlist button
        Button wishlistButton = findViewById(R.id.add_to_wishlist);
        wishlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show feedback for adding to wishlist
                Toast.makeText(ProductActivity.this, "Added to wishlist", Toast.LENGTH_SHORT).show();
            }
        });

        // Add to cart button
        Button cartButton = findViewById(R.id.add_to_cart);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add item to cart
                ShoppingCart.addItem("Cucumber", 99);
                // Show feedback
                Toast.makeText(ProductActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        // View cart button
        Button viewCartButton = findViewById(R.id.view_cart);
        viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}