package com.example.app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.app.models.User;

public class UserDAO {
  public void createUser(User user) {
    String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
    try (Connection conn = DataBaseConnection.getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql)) {
      pStatement.setString(1, user.getUserName());
      pStatement.setString(2, user.getEmail());
      pStatement.executeUpdate();
      System.out.println("created user");
      pStatement.closeOnCompletion();
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Error creating user");
    }
  }
}
