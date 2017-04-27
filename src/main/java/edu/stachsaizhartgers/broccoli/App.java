package edu.stachsaizhartgers.broccoli;

/**
 * Created by Christoph Stach on 4/27/17.
 * <p>
 * Main Class
 */
public class App {
  /**
   * Main (will be invoked when the program launches)
   *
   * @param args Arguments that are passed over the console
   */
  public static void main(String[] args) {
    try {
      TwitterClient twitterClient = new TwitterClient();
      twitterClient.listen();

      System.out.println("Programm beendet!");
    } catch (Throwable throwable) {
      System.out.println(throwable.getMessage());
      System.out.println(throwable);
    }
  }
}
