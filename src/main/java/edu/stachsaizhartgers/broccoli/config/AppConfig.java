package edu.stachsaizhartgers.broccoli.config;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Main config file
 */
public class AppConfig {
  private ApiConfig api;

  /**
   * Default constructor
   */
  public AppConfig() {
  }

  /**
   * Setter constructor
   *
   * @param api value for api
   */
  public AppConfig(ApiConfig api) {
    this.api = api;
  }

  /**
   * Gets api
   *
   * @return value of api
   */
  public ApiConfig getApi() {
    return api;
  }

  /**
   * Sets api
   *
   * @param api value for api
   */
  public void setApi(ApiConfig api) {
    this.api = api;
  }
}
