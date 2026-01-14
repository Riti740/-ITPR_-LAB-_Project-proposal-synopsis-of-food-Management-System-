package com.jdbcconnectivity.FoodManagement.service;

import com.jdbcconnectivity.FoodManagement.model.FoodItem;
import java.util.List;

public interface FoodItemService {
    void addFood(FoodItem item);
    List<FoodItem> getAllFood();
    void updateQuantity(int id, int qty);
    List<FoodItem> getLowStock();
}
