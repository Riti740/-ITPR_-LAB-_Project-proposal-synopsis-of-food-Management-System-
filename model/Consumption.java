package com.jdbcconnectivity.FoodManagement.model;

public class Consumption {
    private int id;
    private int foodItemId;
    private int quantity;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getFoodItemId() { return foodItemId; }
    public void setFoodItemId(int foodItemId) { this.foodItemId = foodItemId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

