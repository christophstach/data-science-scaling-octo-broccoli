package edu.stachsaizhartgers.broccoli.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Object from the twitter stream api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterObject {
  private long id;
  @JsonProperty("id_str")
  private String idStr;
  private String text;

  /**
   * Gets id
   *
   * @return value of id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id
   *
   * @param id value for id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets idStr
   *
   * @return value of idStr
   */
  public String getIdStr() {
    return idStr;
  }

  @Override
  public String toString() {
    return "TwitterObject{" +
      "id=" + id +
      ", idStr='" + idStr + '\'' +
      '}';
  }

  /**
   * Sets idStr
   *
   * @param idStr value for idStr
   */
  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }
}
