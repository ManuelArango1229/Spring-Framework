package com.example.database;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class jdbcConfig {
  @Bean
  public DataSource dataSource() {
    Properties properties = new Properties();
    try (InputStream inStream = getClass().getClassLoader().getResourceAsStream("jdbc.properties")) {
      if (inStream == null) {
        throw new IOException("El archivo jdbc.properties no se encontró en classpath");
      }
      properties.load(inStream);
    } catch (IOException e) {
      throw new RuntimeException("Error al cargar jdbc.properties", e);
    }

    // Debug: Verificar si se cargaron los valores correctamente
    System.out.println("jdbc.url: " + properties.getProperty("jdbc.url"));
    System.out.println("jdbc.username: " + properties.getProperty("jdbc.username"));
    System.out.println("jdbc.password: " + properties.getProperty("jdbc.password"));
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
    dataSource.setUrl(properties.getProperty("jdbc.url"));
    dataSource.setUsername(properties.getProperty("jdbc.username"));
    dataSource.setPassword(properties.getProperty("jdbc.password"));

    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public UserDAO userDao(JdbcTemplate jdbcTemplate) {
    return new UserDAO(jdbcTemplate);
  }
}
