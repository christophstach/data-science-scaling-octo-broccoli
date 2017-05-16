package edu.stachsaizhartgers.broccoli.config;

import java.util.List;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Twitter config
 */
public class TwitterConfig {
  private String authType;
  private AuthConfig auth;
  private String termsFile;
  private float[][] locations;
  private List<String> filters;

  /**
   * Gets authType
   *
   * @return value of authType
   */
  public String getAuthType() {
    return authType;
  }

  /**
   * Gets auth
   *
   * @return value of auth
   */
  public AuthConfig getAuth() {
    return auth;
  }

  /**
   * Gets termsFile
   *
   * @return value of termsFile
   */
  public String getTermsFile() {
    return termsFile;
  }

  /**
   * Gets locations
   *
   * @return value of locations
   */
  public float[][] getLocations() {
    return locations;
  }

  /**
   * Gets filters
   *
   * @return value of filters
   */
  public List<String> getFilters() {
    return filters;
  }
}
