package uon.seng2050.assignment.util;

/**
 * A class for logging to the Tomcat console. Using Java's logger results in long, unreadable log
 * messages.
 *
 * @see java.util.logging.Logger
 * @since 2018-05-23
 */
public class Logger {


  /**
   * Print info.
   *
   * @param message Message to print, with optional formatting specifiers.
   * @param objects Objects to add to formatted message.
   */
  public void info(String message, Object... objects) {
    System.out.println(String.format(message, objects));
  }


  /**
   * Print an indented message.
   *
   * @param message Message to print, with optional formatting specifiers.
   * @param objects Objects to add to formatted message.
   */
  public void fine(String message, Object... objects) {
    info("  " + message, objects);
  }

}
