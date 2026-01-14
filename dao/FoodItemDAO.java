package com.jdbcconnectivity.FoodManagement.dao;

import com.jdbcconnectivity.FoodManagement.model.FoodItem;
import java.util.List;

public interface FoodItemDAO {
    void save(FoodItem item);
    List<FoodItem> findAll();
    void updateQuantity(int id, int qty);
    List<FoodItem> findLowStock();
}
