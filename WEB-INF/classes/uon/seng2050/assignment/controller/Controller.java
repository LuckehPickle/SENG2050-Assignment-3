package uon.seng2050.assignment.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * A class that contains some standard functions for dealing with controllers.
 *
 * @since 2018-05-21
 */
public class Controller {

  private static Logger LOGGER = Logger.getLogger(AuthenticationController.class.getSimpleName());


  /**
   * Logs the start of a HTTP request. Use the returned long to track how long the request lasts.
   *
   * @param request HTTP request object.
   * @return The current time in milliseconds.
   */
  static long logRequestStart(HttpServletRequest request) {

    LOGGER.log(
        Level.INFO, "Handling {0} request to {1}.",
        new Object[]{request.getMethod(), request.getRequestURL().toString()}
    );

    // Return current timestamp
    return System.currentTimeMillis();

  }


  /**
   * Logs the end of a HTTP request. The given long should the system time in milliseconds at the
   * start of the request.
   *
   * @param request HTTP request object.
   */
  static void logRequestEnd(long startTime, HttpServletRequest request) {

    long deltaTime = System.currentTimeMillis() - startTime;

    LOGGER.log(
        Level.INFO, "Finished {0} request at {1}. ({2}ms)",
        new Object[]{ request.getMethod(), request.getRequestURL().toString(), deltaTime }
    );
  }

}
