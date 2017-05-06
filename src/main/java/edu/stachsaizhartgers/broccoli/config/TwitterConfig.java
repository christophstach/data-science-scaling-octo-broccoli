package edu.stachsaizhartgers.broccoli.config;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Twitter config
 */
public class TwitterConfig {
  private String authType;
  private AuthConfig auth;
  private String termsFile;

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
}
