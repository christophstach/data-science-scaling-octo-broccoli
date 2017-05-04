package edu.stachsaizhartgers.broccoli;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.event.Event;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import edu.stachsaizhartgers.broccoli.config.TwitterConfig;
import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * A twitter client using hose bird api client
 */
public class TwitterClient {
  private TwitterConfig config;
  private Hosts hosts;
  private StatusesFilterEndpoint endpoint;
  private Authentication authentication;
  private Client client;

  private BlockingQueue<String> msgQueue;
  private BlockingQueue<Event> eventQueue;

  public TwitterClient() {
    hosts = new HttpHosts(Constants.STREAM_HOST);
    endpoint = new StatusesFilterEndpoint();
    eventQueue = new LinkedBlockingQueue<>(1000);
    msgQueue = new LinkedBlockingQueue<>(100000);


    String termsString = "";
    try {
      termsString = new String(Files.readAllBytes(Paths.get("src/main/resources/terms.txt")));
    } catch (IOException e) {
      e.printStackTrace();
    }

    String[] termsArray = termsString.split(",");
    System.out.println(Arrays.toString(termsArray));

    List<String> terms = Lists.newArrayList(termsArray);
    //endpoint.followings(followings);
    endpoint.trackTerms(terms);


  }

  /**
   * Gets config
   *
   * @return value of config
   */
  public TwitterConfig getConfig() {
    return config;
  }

  /**
   * Sets config
   *
   * @param config value for config
   */
  public void setConfig(TwitterConfig config) {
    this.config = config;
  }

  /**
   * @throws InterruptedException
   */
  public Flowable<String> listen() throws InterruptedException, IOException {
    authentication = new OAuth1(
      config.getAuth().getConsumerKey(),
      config.getAuth().getConsumerSecret(),
      config.getAuth().getToken(),
      config.getAuth().getTokenSecret()
    );


    ClientBuilder builder = new ClientBuilder()
      .name("broccoli")
      .hosts(hosts)
      .authentication(authentication)
      .endpoint(endpoint)
      .processor(new StringDelimitedProcessor(msgQueue))
      .eventMessageQueue(eventQueue);

    client = builder.build();
    client.connect();


    Flowable<String> flowable = new Flowable<String>() {
      @Override
      protected void subscribeActual(Subscriber<? super String> subscriber) {

        while (!client.isDone()) {

          String s = null;
          try {
            s = msgQueue.take();

            subscriber.onNext(s);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        }
      }
    };

    return flowable;
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();

    client.stop();
  }
}
