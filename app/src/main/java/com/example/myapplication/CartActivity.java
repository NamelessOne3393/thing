package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private LinearLayout cartItemsContainer;
    private TextView totalPriceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItemsContainer = findViewById(R.id.cart_items_container);
        totalPriceView = findViewById(R.id.total_price);
        Button checkoutButton = findViewById(R.id.checkout_button);

        refreshCart();

        // Set up checkout button
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ShoppingCart.getItemNames().isEmpty()) {
                    Toast.makeText(CartActivity.this, "Your cart is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshCart();
    }

    private void refreshCart() {
        cartItemsContainer.removeAllViews();
        List<String> items = ShoppingCart.getItemNames();

        if (items.isEmpty()) {
            TextView emptyCart = new TextView(this);
            emptyCart.setText("Your cart is empty");
            emptyCart.setTextSize(18);
            emptyCart.setPadding(0, 50, 0, 50);
            cartItemsContainer.addView(emptyCart);
            totalPriceView.setText("Total: 0$");
        } else {
            for (String itemName : items) {
                View itemView = getLayoutInflater().inflate(R.layout.cart_item, cartItemsContainer, false);

                TextView nameView = itemView.findViewById(R.id.item_name);
                TextView priceView = itemView.findViewById(R.id.item_price);
                TextView quantityView = itemView.findViewById(R.id.item_quantity);
                Button increaseBtn = itemView.findViewById(R.id.increase_quantity);
                Button decreaseBtn = itemView.findViewById(R.id.decrease_quantity);

                int price = ShoppingCart.getPrice(itemName);
                int quantity = ShoppingCart.getQuantity(itemName);

                nameView.setText(itemName);
                priceView.setText(price + "$");
                quantityView.setText(String.valueOf(quantity));

                final String finalItemName = itemName;

                increaseBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShoppingCart.updateQuantity(finalItemName, ShoppingCart.getQuantity(finalItemName) + 1);
                        refreshCart();
                    }
                });

                decreaseBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int currentQty = ShoppingCart.getQuantity(finalItemName);
                        if (currentQty > 1) {
                            ShoppingCart.updateQuantity(finalItemName, currentQty - 1);
                        } else {
                            ShoppingCart.removeItem(finalItemName);
                            Toast.makeText(CartActivity.this, "Item removed from cart", Toast.LENGTH_SHORT).show();
                        }
                        refreshCart();
                    }
                });

                cartItemsContainer.addView(itemView);
            }

            totalPriceView.setText("Total: " + ShoppingCart.getTotal() + "$");
        }
    }
}
