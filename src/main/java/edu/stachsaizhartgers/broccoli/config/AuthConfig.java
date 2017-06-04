package edu.stachsaizhartgers.broccoli.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * OAuth config
 */
@Component
@ConfigurationProperties(prefix = "api.twitter.auth")
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
   * Sets consumerKey
   *
   * @param consumerKey value for consumerKey
   */
  public void setConsumerKey(String consumerKey) {
    this.consumerKey = consumerKey;
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
   * Sets consumerSecret
   *
   * @param consumerSecret value for consumerSecret
   */
  public void setConsumerSecret(String consumerSecret) {
    this.consumerSecret = consumerSecret;
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
   * Sets token
   *
   * @param token value for token
   */
  public void setToken(String token) {
    this.token = token;
  }

  /**
   * Gets tokenSecret
   *
   * @return value of tokenSecret
   */
  public String getTokenSecret() {
    return tokenSecret;
  }

  /**
   * Sets tokenSecret
   *
   * @param tokenSecret value for tokenSecret
   */
  public void setTokenSecret(String tokenSecret) {
    this.tokenSecret = tokenSecret;
  }
}
