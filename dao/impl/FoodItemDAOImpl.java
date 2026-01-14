package com.jdbcconnectivity.FoodManagement.dao.impl;

import com.jdbcconnectivity.FoodManagement.dao.FoodItemDAO;
import com.jdbcconnectivity.FoodManagement.model.FoodItem;
import com.jdbcconnectivity.FoodManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodItemDAOImpl implements FoodItemDAO {

    public void save(FoodItem item) {
        String sql = "INSERT INTO food_item(name, quantity) VALUES (?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<FoodItem> findAll() {
        List<FoodItem> list = new ArrayList<>();
        String sql = "SELECT * FROM food_item";
        try (Connection c = DBConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                FoodItem f = new FoodItem();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("name"));
                f.setQuantity(rs.getInt("quantity"));
                list.add(f);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void updateQuantity(int id, int qty) {
        String sql = "UPDATE food_item SET quantity = quantity + ? WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, qty);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<FoodItem> findLowStock() {
        List<FoodItem> list = new ArrayList<>();
        String sql = "SELECT * FROM food_item WHERE quantity <= 10";
        try (Connection c = DBConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                FoodItem f = new FoodItem();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("name"));
                f.setQuantity(rs.getInt("quantity"));
                list.add(f);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
