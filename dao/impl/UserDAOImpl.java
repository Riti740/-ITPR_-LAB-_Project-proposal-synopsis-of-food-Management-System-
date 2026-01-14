package com.jdbcconnectivity.FoodManagement.dao.impl;

import com.jdbcconnectivity.FoodManagement.dao.UserDAO;
import com.jdbcconnectivity.FoodManagement.model.User;
import com.jdbcconnectivity.FoodManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    public void save(User user) {
        String sql = "INSERT INTO user(name, role) VALUES (?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getRole());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Connection c = DBConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setRole(rs.getString("role"));
                list.add(u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
