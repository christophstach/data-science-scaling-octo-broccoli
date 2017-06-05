package edu.stachsaizhartgers.broccoli.consumer;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.functions.Consumer;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Christoph Stach on 5/8/17.
 * <p>
 * LogConsumer
 */
public class LogConsumer implements Consumer<String> {
  private ObjectMapper mapper;
  private final static Logger logger = Logger.getLogger(LogConsumer.class.getName());

  /**
   * Setter constructor
   *
   * @param mapper value of mapper
   */
  public LogConsumer(ObjectMapper mapper) {
    this.mapper = mapper;
    logger.info("Created " + this.getClass().getName() + "...");
  }

  @Override
  public void accept(String s) {
    try {
      JsonNode json = mapper.readTree(s);

      if (json.has("created_at")) {
        logger.info(json.get("text").asText().replace("\n", ""));
      }
    } catch (IOException e) {
      logger.warning("Couldn't parse tweet JSON.");
      e.printStackTrace();
    }
  }
}
