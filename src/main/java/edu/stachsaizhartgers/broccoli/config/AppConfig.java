package edu.stachsaizhartgers.broccoli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Main config file
 */
@Component
@ConfigurationProperties()
public class AppConfig {
  @Autowired
  private ApiConfig api;

  @Autowired
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

  /**
   * Sets consumer
   *
   * @param consumer value for consumer
   */
  public void setConsumer(List<String> consumer) {
    this.consumer = consumer;
  }
}
