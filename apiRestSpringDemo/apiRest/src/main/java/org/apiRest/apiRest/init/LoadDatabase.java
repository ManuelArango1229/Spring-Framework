package org.apiRest.apiRest.init;

import org.apiRest.apiRest.entities.Employees;
import org.apiRest.apiRest.repositories.EmployeesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
  private Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeesRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Employees("Bilbo Baggins", "burglar")));
      log.info("Preloading " + repository.save(new Employees("Frodo Baggins", "thief")));
    };
  }
}
