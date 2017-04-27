package edu.stachsaizhartgers.broccoli;

import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.event.Event;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.BasicAuth;
import com.twitter.hbc.httpclient.auth.OAuth1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * A twitter client using hose bird api client
 */
public class TwitterClient {
  private Hosts hosts;
  private StatusesFilterEndpoint endpoint;
  private Authentication authentication;
  private Client client;

  private BlockingQueue<String> msgQueue;
  private BlockingQueue<Event> eventQueue;

  public TwitterClient() {
    hosts = new HttpHosts(Constants.STREAM_HOST);
    endpoint = new StatusesFilterEndpoint();
    authentication = new OAuth1(
      
    );

    eventQueue = new LinkedBlockingQueue<>(1000);
    msgQueue = new LinkedBlockingQueue<>(100000);

    ClientBuilder builder = new ClientBuilder()
      .name("broccoli")
      .hosts(hosts)
      .authentication(authentication)
      .endpoint(endpoint)
      .processor(new StringDelimitedProcessor(msgQueue))
      .eventMessageQueue(eventQueue);


    client = builder.build();
    client.connect();
  }

  /**
   * @throws InterruptedException
   */
  public void listen() throws InterruptedException {
    while (!client.isDone()) {
      System.out.println(msgQueue.take());
    }
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();

    client.stop();
  }
}
