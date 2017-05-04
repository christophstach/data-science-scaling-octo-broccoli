package edu.stachsaizhartgers.broccoli;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Christoph Stach on 5/4/17.
 *
 * Writes JSON to a MongoDB database
 */
public class MongoDbSubscriber implements Subscriber<String> {
  @Override
  public void onSubscribe(Subscription subscription) {

  }

  @Override
  public void onNext(String s) {
    System.out.println(s);
  }

  @Override
  public void onError(Throwable throwable) {

  }

  @Override
  public void onComplete() {

  }
}
