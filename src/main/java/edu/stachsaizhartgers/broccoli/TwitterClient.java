package edu.stachsaizhartgers.broccoli;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
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
import edu.stachsaizhartgers.broccoli.data.TwitterObject;

import java.io.IOException;
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


    List<String> terms = Lists.newArrayList("Laila");
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
  public void listen() throws InterruptedException, IOException {
    ObjectMapper mapper = new ObjectMapper(new JsonFactory());

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

    while (!client.isDone()) {
      String s = msgQueue.take();


      System.out.println(s);
      //System.out.println(mapper.readValue(s, TwitterObject.class));
      //System.out.println(eventQueue.take());
    }
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();

    client.stop();
  }
}
