package edu.stachsaizhartgers.broccoli.config;

/**
 * Created by Christoph Stach on 5/6/17.
 * <p>
 * Config file for the database
 */
public class DatabaseConfig {
  private MongoConfig mongo;
  private String file;

  /**
   * Gets mongo
   *
   * @return value of mongo
   */
  public MongoConfig getMongo() {
    return mongo;
  }

  /**
   * Gets file
   *
   * @return value of file
   */
  public String getFile() {
    return file;
  }
}
