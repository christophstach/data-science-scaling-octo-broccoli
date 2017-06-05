package edu.stachsaizhartgers.broccoli.consumer;

import io.reactivex.functions.Consumer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Christoph Stach on 5/8/17.
 * <p>
 * FileConsumer
 */
public class FileConsumer implements Consumer<String> {
  private File file;
  private FileWriter fileWriter;
  private final static Logger logger = Logger.getLogger(FileConsumer.class.getName());


  /**
   * Setter constructor.
   * Creates a new file if it doesn't exists
   *
   * @param filePath value of filePath
   */
  public FileConsumer(String filePath) throws IOException {
    this.file = new File(filePath);
    this.fileWriter = new FileWriter(file, true);


    if (!file.exists()) {
      file.createNewFile();
    }

    logger.info("Created " + this.getClass().getName() + "...");
  }

  @Override
  public void accept(String s) throws Exception {
    if(s.contains("created_at")) {
      this.fileWriter.append(s);
    }
  }
}
