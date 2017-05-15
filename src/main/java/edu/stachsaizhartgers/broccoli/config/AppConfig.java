package edu.stachsaizhartgers.broccoli.config;

import java.util.List;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Main config file
 */
public class AppConfig {
  private ApiConfig api;
  private DatabaseConfig database;
  private List<String> consumer;

  /**
   * Gets api
   *
   * @return value of api
   */
  public ApiConfig getApi() {
    return api;
  }

  /**
   * Gets database
   *
   * @return value of database
   */
  public DatabaseConfig getDatabase() {
    return database;
  }

  /**
   * Gets consumer
   *
   * @return value of consumer
   */
  public List<String> getConsumer() {
    return consumer;
  }
}
