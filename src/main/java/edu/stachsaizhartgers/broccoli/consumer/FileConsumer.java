package edu.stachsaizhartgers.broccoli.consumer;

import io.reactivex.functions.Consumer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Christoph Stach on 5/8/17.
 * <p>
 * FileConsumer
 */
public class FileConsumer implements Consumer<String> {
  private File file;
  private FileWriter fileWriter;

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

    System.out.println("Created " + this.getClass().getName() + "...");
  }

  @Override
  public void accept(String s) throws Exception {
    if(s.matches("(.*)created_at(.*)")) {
      this.fileWriter.append(s);
    }
  }
}
