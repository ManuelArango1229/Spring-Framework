package org.demoCrud.demo.repository;

import java.util.List;

import org.demoCrud.demo.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
  Client findById(int id);

  List<Client> findAll();

  List<Client> findBylastName(String lastName);
}
