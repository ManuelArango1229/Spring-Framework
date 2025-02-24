package org.demoCrud.demo;

import org.demoCrud.demo.model.Client;
import org.demoCrud.demo.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

  private static Logger Log = LoggerFactory.getLogger(DemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(ClientRepository repository) {
    return (args) -> {
      repository.save(new Client("Juan", "Arango"));
      repository.save(new Client("Stiven", "Henao"));
      repository.save(new Client("Stiven", "Arango"));

      Log.info("Consultar todo");

      repository.findAll().forEach(client -> {
        Log.info(client.toString());
      });

      Log.info("");

      Log.info("Consultar mediante findById");

      Log.info(repository.findById(1).toString());

      Log.info("consultar mediante grupo de apellido");

      repository.findBylastName("Arango").forEach(client -> {
        Log.info(client.toString());
      });
    };
  }
}
