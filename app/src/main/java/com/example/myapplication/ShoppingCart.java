package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    // Using static fields to maintain cart state across activities
    private static Map<String, Float> items = new HashMap<>();
    private static Map<String, Integer> quantities = new HashMap<>();
    private static String deliveryMethod = "Pickup"; // Default delivery method

    // Add item to cart
    public static void addItem(String itemName, Float price) {
        if (items.containsKey(itemName)) {
            quantities.put(itemName, quantities.get(itemName) + 1);
        } else {
            items.put(itemName, price);
            quantities.put(itemName, 1);
        }
    }

    // Update quantity
    public static void updateQuantity(String itemName, int quantity) {
        if (quantity <= 0) {
            removeItem(itemName);
        } else {
            quantities.put(itemName, quantity);
        }
    }

    // Remove item from cart
    public static void removeItem(String itemName) {
        items.remove(itemName);
        quantities.remove(itemName);
    }

    // Get all items
    public static List<String> getItemNames() {
        return new ArrayList<>(items.keySet());
    }

    // Get price for item
    public static Float getPrice(String itemName) {
        return items.getOrDefault(itemName, 0F);
    }

    // Get quantity for item
    public static int getQuantity(String itemName) {
        return quantities.getOrDefault(itemName, 0);
    }

    // Calculate total
    public static Float getTotal() {
        Float total = 0F;
        for (String item : items.keySet()) {
            total += items.get(item) * quantities.get(item);
        }
        return total;
    }

    // Set delivery method
    public static void setDeliveryMethod(String method) {
        deliveryMethod = method;
    }

    // Get delivery method
    public static String getDeliveryMethod() {
        return deliveryMethod;
    }

    // Clear cart
    public static void clearCart() {
        items.clear();
        quantities.clear();
    }
}