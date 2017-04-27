package edu.stachsaizhartgers.broccoli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import edu.stachsaizhartgers.broccoli.config.AppConfig;

import java.io.File;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Main Class
 */
public class App {
  /**
   * Main (will be invoked when the program launches)
   *
   * @param args Arguments that are passed over the console
   */
  public static void main(String[] args) {
    try {
      ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
      AppConfig appConfig = mapper.readValue(new File("src/main/resources/config.yml"), AppConfig.class);

      TwitterClient twitterClient = new TwitterClient();
      twitterClient.setConfig(appConfig.getApi().getTwitter());
      twitterClient.listen();

      System.out.println("Programm beendet!");
    } catch (Throwable throwable) {
      System.out.println(throwable.getMessage());
      System.out.println(throwable);
    }
  }
}
