package edu.stachsaizhartgers.broccoli.consumer;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.functions.Consumer;

import java.io.IOException;

/**
 * Created by Christoph Stach on 5/8/17.
 * <p>
 * ConsoleLogConsumer
 */
public class ConsoleLogConsumer implements Consumer<String> {
  private ObjectMapper mapper;

  /**
   * Setter constructor
   *
   * @param mapper value of mapper
   */
  public ConsoleLogConsumer(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public void accept(String s) {

    try {
      JsonNode json = mapper.readTree(s);
      System.out.println(
        "[" + json.get("created_at").asText() + "]: "
        + json.get("text").asText().replace("\n", "")
      );
    } catch (IOException e) {
      System.out.println("Couldn't parse tweet JSON.");
      e.printStackTrace();
    }

  }
}
