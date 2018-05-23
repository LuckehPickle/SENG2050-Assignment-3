package uon.seng2050.assignment.controller;

import java.util.Map;
import java.util.StringJoiner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.exception.HttpStatusCode;
import uon.seng2050.assignment.util.Logger;

/**
 * A class that contains some standard functions for dealing with controllers.
 *
 * @since 2018-05-21
 */
public class Controller {

  private static Logger LOGGER = new Logger();


  /**
   * Logs the start of a HTTP request. Use the returned long to track how long the request lasts.
   *
   * @param request HTTP request object.
   * @return The current time in milliseconds.
   */
  static long logRequestStart(HttpServletRequest request) {

    LOGGER.info("\nStarted %s \"%s\"",
        request.getMethod(),
        request.getRequestURI());

    logParameters(request.getParameterMap());
    return System.currentTimeMillis();

  }


  /**
   * Logs the end of a HTTP request. The given long should the system time in milliseconds at the
   * start of the request.
   *
   * @param response HTTP response object.
   */
  static void logRequestEnd(long startTime, HttpServletResponse response) {

    // Get status
    HttpStatusCode status = HttpStatusCode.fromCode(response.getStatus());
    String statusInfo;

    if (status != null) {
      statusInfo = String.format("%d %s", status.getCode(), status.getShortName());
    } else {
      statusInfo = String.valueOf(response.getStatus());
    }

    LOGGER.info("Completed %s in %dms.", statusInfo,
        System.currentTimeMillis() - startTime);

  }


  /**
   * Logs a set of request parameters.
   *
   * @param params Parameter map.
   * @see #logRequestStart(HttpServletRequest)
   */
  private static void logParameters(Map<String, String[]> params) {

    // Ensure params are not empty
    if (params.isEmpty()) {
      return;
    }

    StringJoiner joiner = new StringJoiner(", ", "{", "}");

    // Iterate over params
    for (String key : params.keySet()) {
      joiner.add(String.format("%s => %s", key, getParamString(params.get(key))));
    }

    LOGGER.info("Parameters %s", joiner.toString());

  }


  /**
   * Takes an array of params, and returns their string form.
   *
   * @param params An array of parameters.
   * @return String form of paramater array.
   * @see #logParameters(Map)
   */
  private static String getParamString(String[] params) {

    // Handle basic cases
    if (params.length == 0) {
      return "\"\"";
    } else if (params.length == 1) {
      return "\"" + params[0] + "\"";
    }

    StringJoiner joiner = new StringJoiner(", ", "[", "]");

    // Iterate over params
    for (String param : params) {
      joiner.add("\"" + param + "\"");
    }

    return joiner.toString();

  }

}
