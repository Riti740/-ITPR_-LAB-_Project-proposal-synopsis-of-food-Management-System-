package com.jdbcconnectivity.FoodManagement.dao.impl;

import com.jdbcconnectivity.FoodManagement.dao.PurchaseDAO;
import com.jdbcconnectivity.FoodManagement.model.Purchase;
import com.jdbcconnectivity.FoodManagement.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PurchaseDAOImpl implements PurchaseDAO {

    @Override
    public void save(Purchase purchase) {
        String sql = "INSERT INTO purchase(food_item_id, quantity) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, purchase.getFoodItemId());
            ps.setInt(2, purchase.getQuantity());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
