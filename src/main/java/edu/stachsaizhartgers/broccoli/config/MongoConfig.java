package edu.stachsaizhartgers.broccoli.config;

/**
 * Created by Christoph Stach on 5/6/17.
 * <p>
 * Config file for MongoDB
 */
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
   * Gets port
   *
   * @return value of port
   */
  public int getPort() {
    return port;
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
   * Gets collection
   *
   * @return value of collection
   */
  public String getCollection() {
    return collection;
  }
}
