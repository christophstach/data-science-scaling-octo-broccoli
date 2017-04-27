package edu.stachsaizhartgers.broccoli.config;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Twitter config
 */
public class TwitterConfig {
  private String authType;
  private AuthConfig auth;

  /**
   * Default constructor
   */
  public TwitterConfig() {
  }

  /**
   * Setter constructor
   *
   * @param authType value of authType
   * @param auth     value of auth
   */
  public TwitterConfig(String authType, AuthConfig auth) {
    this.authType = authType;
    this.auth = auth;
  }

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


  @Override
  public String toString() {
    return "TwitterConfig{" +
      "authType='" + authType + '\'' +
      ", auth=" + auth +
      '}';
  }
}
