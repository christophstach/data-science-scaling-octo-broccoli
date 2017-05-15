package edu.stachsaizhartgers.broccoli.config;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * OAuth config
 */
public class AuthConfig {
  private String consumerKey;
  private String consumerSecret;
  private String token;
  private String tokenSecret;

  /**
   * Gets consumerKey
   *
   * @return value of consumerKey
   */
  public String getConsumerKey() {
    return consumerKey;
  }

  /**
   * Gets consumerSecret
   *
   * @return value of consumerSecret
   */
  public String getConsumerSecret() {
    return consumerSecret;
  }

  /**
   * Gets token
   *
   * @return value of token
   */
  public String getToken() {
    return token;
  }

  /**
   * Gets tokenSecret
   *
   * @return value of tokenSecret
   */
  public String getTokenSecret() {
    return tokenSecret;
  }
}
