package com.example.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(DataBaseConfig.URL, DataBaseConfig.USER, DataBaseConfig.PASSWORD);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Error in connection database");
    }
  }

}
