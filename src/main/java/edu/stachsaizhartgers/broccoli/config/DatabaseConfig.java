package edu.stachsaizhartgers.broccoli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Christoph Stach on 5/6/17.
 * <p>
 * Config file for the database
 */
@Component
public class DatabaseConfig {
  @Autowired
  private MongoConfig mongo;

  @Value("${database.file}")
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
