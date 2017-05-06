package edu.stachsaizhartgers.broccoli.config;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Main config file
 */
public class AppConfig {
  private ApiConfig api;
  private DatabaseConfig database;

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
}
