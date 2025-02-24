
package org.demoCrud.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private String lastName;

  public Client(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Client() {
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return "Client [id=" + id + ", name=" + name + ", lastName=" + lastName + "]";
  }

}
