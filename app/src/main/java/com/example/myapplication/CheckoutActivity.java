package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private RadioGroup deliveryOptions;
    private Button completeOrderButton;
    private TextView totalPriceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Initialize views
        deliveryOptions = findViewById(R.id.delivery_options);
        completeOrderButton = findViewById(R.id.complete_order_button);
        totalPriceView = findViewById(R.id.checkout_total);

        // Set total price
        totalPriceView.setText("Total: " + ShoppingCart.getTotal() + "$");

        // Handle delivery method selection
        deliveryOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = findViewById(checkedId);
                if (selectedButton != null) {
                    ShoppingCart.setDeliveryMethod(selectedButton.getText().toString());
                    // Provide feedback
                    Toast.makeText(CheckoutActivity.this,
                            "Selected: " + selectedButton.getText(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Default delivery method selection
        if (ShoppingCart.getDeliveryMethod().equals("Delivery")) {
            ((RadioButton) findViewById(R.id.delivery_option)).setChecked(true);
        } else {
            ((RadioButton) findViewById(R.id.pickup_option)).setChecked(true);
        }

        // Complete order button
        completeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Normally would handle payment processing here
                // For this prototype, just show confirmation and clear cart
                String message = "Order placed successfully! " +
                        "Your items will be available via " +
                        ShoppingCart.getDeliveryMethod();

                Toast.makeText(CheckoutActivity.this, message, Toast.LENGTH_LONG).show();

                //i am adding the code to add this stuff to history
                OrderHistory.checkOut();



                // Clear cart and go back
                ShoppingCart.clearCart();
                finish();
            }
        });
    }
}