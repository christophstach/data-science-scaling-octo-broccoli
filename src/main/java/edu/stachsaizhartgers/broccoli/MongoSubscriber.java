package edu.stachsaizhartgers.broccoli;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.stachsaizhartgers.broccoli.config.MongoConfig;
import org.bson.Document;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Christoph Stach on 5/4/17.
 * <p>
 * Writes JSON to a MongoDB database
 */
public class MongoSubscriber implements Subscriber<String> {
  private MongoConfig config;
  private MongoClient client;
  private MongoDatabase database;
  private MongoCollection<Document> collection;

  public MongoSubscriber(MongoConfig config) {
    this.config = config;
    client = new MongoClient(config.getHost(), config.getPort());
    database = client.getDatabase(config.getDatabase());
    collection = database.getCollection(config.getCollection());

    System.out.println("Connection to MongoDB established!");
  }

  @Override
  public void onSubscribe(Subscription subscription) {
  }

  @Override
  public void onNext(String s) {
    collection.insertOne(Document.parse(s));
    System.out.println(".");
  }

  @Override
  public void onError(Throwable throwable) {

  }

  @Override
  public void onComplete() {

  }
}
