package com.example.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.models.User;

@Repository
public class UserDAO {
  private final JdbcTemplate jdbcTemplate;

  public UserDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private final RowMapper<User> userRowMapper = new RowMapper<User>() {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"));
    }
  };

  public void createUser(User user) {

    String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
    jdbcTemplate.update(sql, user.getUserName(), user.getEmail());
    System.out.println("Usuario creado exitosamente.");
  }

  public User getUserById(int id) {
    String sql = "SELECT * FROM users WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, userRowMapper, id);
  }
}
