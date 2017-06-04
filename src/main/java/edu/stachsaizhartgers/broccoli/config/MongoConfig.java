package edu.stachsaizhartgers.broccoli.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Christoph Stach on 5/6/17.
 * <p>
 * Config file for MongoDB
 */
@Component
@ConfigurationProperties(prefix = "database.mongo")
public class MongoConfig {
  private String host;

  private int port;

  private String database;

  private String collection;

  /**
   * Gets host
   *
   * @return value of host
   */
  public String getHost() {
    return host;
  }

  /**
   * Sets host
   *
   * @param host value for host
   */
  public void setHost(String host) {
    this.host = host;
  }

  /**
   * Gets port
   *
   * @return value of port
   */
  public int getPort() {
    return port;
  }

  /**
   * Sets port
   *
   * @param port value for port
   */
  public void setPort(int port) {
    this.port = port;
  }

  /**
   * Gets database
   *
   * @return value of database
   */
  public String getDatabase() {
    return database;
  }

  /**
   * Sets database
   *
   * @param database value for database
   */
  public void setDatabase(String database) {
    this.database = database;
  }

  /**
   * Gets collection
   *
   * @return value of collection
   */
  public String getCollection() {
    return collection;
  }

  /**
   * Sets collection
   *
   * @param collection value for collection
   */
  public void setCollection(String collection) {
    this.collection = collection;
  }
}
