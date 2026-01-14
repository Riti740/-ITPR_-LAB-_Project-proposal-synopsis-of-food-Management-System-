package com.jdbcconnectivity.FoodManagement.dao.impl;

import com.jdbcconnectivity.FoodManagement.dao.ConsumptionDAO;
import com.jdbcconnectivity.FoodManagement.model.Consumption;
import com.jdbcconnectivity.FoodManagement.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConsumptionDAOImpl implements ConsumptionDAO {

    @Override
    public void save(Consumption consumption) {
        String sql = "INSERT INTO consumption(food_item_id, quantity) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, consumption.getFoodItemId());
            ps.setInt(2, consumption.getQuantity());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
