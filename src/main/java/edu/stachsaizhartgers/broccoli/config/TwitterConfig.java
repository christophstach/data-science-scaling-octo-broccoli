package edu.stachsaizhartgers.broccoli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Twitter config
 */
@Component
@ConfigurationProperties(prefix = "api.twitter")
public class TwitterConfig {
  private String authType;

  @Autowired
  private AuthConfig auth;

  private String termsFile;

  private List<List<Double>> locations;

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
   * Sets authType
   *
   * @param authType value for authType
   */
  public void setAuthType(String authType) {
    this.authType = authType;
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
   * Sets auth
   *
   * @param auth value for auth
   */
  public void setAuth(AuthConfig auth) {
    this.auth = auth;
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
   * Sets termsFile
   *
   * @param termsFile value for termsFile
   */
  public void setTermsFile(String termsFile) {
    this.termsFile = termsFile;
  }

  /**
   * Gets locations
   *
   * @return value of locations
   */
  public List<List<Double>> getLocations() {
    return locations;
  }

  /**
   * Sets locations
   *
   * @param locations value for locations
   */
  public void setLocations(List<List<Double>> locations) {
    this.locations = locations;
  }

  /**
   * Gets filters
   *
   * @return value of filters
   */
  public List<String> getFilters() {
    return filters;
  }

  /**
   * Sets filters
   *
   * @param filters value for filters
   */
  public void setFilters(List<String> filters) {
    this.filters = filters;
  }
}
