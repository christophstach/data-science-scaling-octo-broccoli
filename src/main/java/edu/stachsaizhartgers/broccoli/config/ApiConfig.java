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
   * Setter constructor
   *
   * @param twitter value for twitter
   */
  public ApiConfig(TwitterConfig twitter) {
    this.twitter = twitter;
  }

  /**
   * Gets twitter
   *
   * @return value of twitter
   */
  public TwitterConfig getTwitter() {
    return twitter;
  }

  /**
   * Sets twitter
   *
   * @param twitter value for twitter
   */
  public void setTwitter(TwitterConfig twitter) {
    this.twitter = twitter;
  }

  @Override
  public String toString() {
    return "ApiConfig{" +
      "twitter=" + twitter +
      '}';
  }
}
