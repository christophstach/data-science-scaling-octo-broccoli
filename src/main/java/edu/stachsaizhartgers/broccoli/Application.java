package edu.stachsaizhartgers.broccoli;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stachsaizhartgers.broccoli.config.AppConfig;
import edu.stachsaizhartgers.broccoli.consumer.FileConsumer;
import edu.stachsaizhartgers.broccoli.consumer.LogConsumer;
import edu.stachsaizhartgers.broccoli.consumer.MongoConsumer;
import io.reactivex.flowables.ConnectableFlowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Main Class
 */
@SpringBootApplication
public class Application {
  private final static Logger logger = Logger.getLogger(Application.class.getName());

  @Autowired
  private AppConfig appConfig;

  /**
   * Main (will be invoked when the program launches)
   *
   * @param args Arguments that are passed over the console
   */
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder()
      .sources(Application.class)
      .bannerMode(Banner.Mode.OFF)
      .run(args);

    Application app = context.getBean(Application.class);
    app.start();
  }

  /**
   * Is called when a stream error occurs
   *
   * @param e The exception
   */
  private void error(Throwable e) {
    logger.log(Level.WARNING, e.getMessage(), e);
  }

  /**
   * Starts the logic
   */
  private void start() {
    try {
      TwitterClient twitterClient = new TwitterClient(appConfig.getApi().getTwitter());
      ConnectableFlowable<String> stream = twitterClient.listen();

      for (String consumer : appConfig.getConsumer()) {
        switch (consumer) {
          case "LogConsumer":
            stream.subscribe(new LogConsumer(new ObjectMapper()), this::error);
            break;
          case "FileConsumer":
            stream.subscribe(new FileConsumer(appConfig.getDatabase().getFile()), this::error);
            break;
          case "MongoConsumer":
            stream.subscribe(new MongoConsumer(appConfig.getDatabase().getMongo()), this::error);
            break;
        }
      }

      stream.connect();
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}
