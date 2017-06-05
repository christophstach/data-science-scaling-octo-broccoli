package edu.stachsaizhartgers.broccoli.consumer;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.stachsaizhartgers.broccoli.config.MongoConfig;
import io.reactivex.functions.Consumer;
import org.bson.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.logging.Logger;

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
  private final static Logger logger = Logger.getLogger(MongoConsumer.class.getName());

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

    logger.info("Connection to MongoDB established.");
    logger.info("Created " + this.getClass().getName() + "...");
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
      Document doc = Document.parse(s);
      long ts = Long.parseLong(doc.get("timestamp_ms").toString());

      doc.append("created_at_date", new Date(ts));
      doc.append("timestamp_ms_long", ts);
      collection.insertOne(doc);
    }
  }
}
