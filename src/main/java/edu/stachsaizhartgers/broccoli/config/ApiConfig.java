package edu.stachsaizhartgers.broccoli.config;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Apis config
 */
public class ApiConfig {
  private TwitterConfig twitter;

  /**
   * Default constructor
   */
  public ApiConfig() {
  }

  /**
   * @param twitter
   */
  public ApiConfig(TwitterConfig twitter) {
    this.twitter = twitter;
  }
}
