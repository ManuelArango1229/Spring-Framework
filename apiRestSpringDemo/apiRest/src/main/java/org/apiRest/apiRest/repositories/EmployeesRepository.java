package org.apiRest.apiRest.repositories;

import org.apiRest.apiRest.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
  public Employees findById(int id);

  public Employees findByName(String name);
}
