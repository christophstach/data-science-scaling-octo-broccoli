package edu.stachsaizhartgers.broccoli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import edu.stachsaizhartgers.broccoli.config.AppConfig;
import io.reactivex.Flowable;

import java.io.File;
import java.util.Arrays;

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
      AppConfig appConfig = mapper.readValue(new File("./config/config.yml"), AppConfig.class);

      TwitterClient twitterClient = new TwitterClient(appConfig.getApi().getTwitter());
      Flowable<String> flowable = twitterClient.listen();

      flowable.subscribe(new MongoConsumer(appConfig.getDatabase().getMongo()));
      
      System.out.println("Programm beendet!");
    } catch (NullPointerException e) {
      System.out.println(Arrays.toString(e.getStackTrace()));

    } catch (Throwable throwable) {
      System.out.println(throwable);
    }
  }
}
