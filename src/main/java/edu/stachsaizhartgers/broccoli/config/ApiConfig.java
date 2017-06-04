package edu.stachsaizhartgers.broccoli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Apis config
 */
@Component
public class ApiConfig {
  @Autowired
  private TwitterConfig twitter;

  /**
   * Gets twitter
   *
   * @return value of twitter
   */
  public TwitterConfig getTwitter() {
    return twitter;
  }
}
