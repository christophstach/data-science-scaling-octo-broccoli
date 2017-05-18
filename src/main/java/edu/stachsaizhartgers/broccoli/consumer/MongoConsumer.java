package edu.stachsaizhartgers.broccoli.consumer;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.stachsaizhartgers.broccoli.config.MongoConfig;
import io.reactivex.functions.Consumer;
import org.bson.Document;

/**
 * Created by Christoph Stach on 5/4/17.
 * <p>
 * Writes JSON to a MongoDB database
 */
public class MongoConsumer implements Consumer<String> {
  private MongoConfig config;
  private MongoClient client;
  private MongoDatabase database;
  private MongoCollection<Document> collection;

  /**
   * MongoConsumer needs a config for the MongoDb database
   *
   * @param c value of the config
   */
  public MongoConsumer(MongoConfig c) {
    this.config = c;
    client = new MongoClient(config.getHost(), config.getPort());
    database = client.getDatabase(config.getDatabase());
    collection = database.getCollection(config.getCollection());

    System.out.println("Connection to MongoDB established.");
    System.out.println("Created " + this.getClass().getName() + "...");
  }

  /**
   * Defines what should happen with the string from the twitter streaming api.
   * Here the string will be simply parse to a JSON object and put into the MongoDB
   *
   * @param s The JSON encoded string
   * @throws Exception On error
   */
  @Override
  public void accept(String s) throws Exception {
    if(s.contains("created_at")) {
      collection.insertOne(Document.parse(s));
    }
  }
}
