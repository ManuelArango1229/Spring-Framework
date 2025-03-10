package com.example.models;

public class User {
  private int id;
  private String userName;
  private String email;

  public User() {
  }

  public User(String userName, String email) {
    this.userName = userName;
    this.email = email;
  }

  public User(int id, String userName, String email) {
    this.id = id;
    this.userName = userName;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", userName=" + userName + ", email=" + email + "]";
  }

}
