package uon.seng2050.assignment.controller;

import java.io.IOException;
import java.util.Map;
import java.util.StringJoiner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.exception.HttpStatusCode;
import uon.seng2050.assignment.util.Logger;
import uon.seng2050.assignment.util.PageUtil;

/**
 * A standard controller class, containing for the most part simply logging functions.
 *
 * @since 2018-05-21
 */
abstract class Controller extends HttpServlet {


  protected static Logger LOGGER = new Logger();


  /**
   * Catches all HTTP requests.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    long start = logRequestStart(request);

    try {
      handleRequest(request, response);
    } catch (HttpException exception) {
      // Gracefully handle HTTP exception
      response.setStatus(exception.getStatusCode());
      request.setAttribute("message", exception.getMessage());
      PageUtil.render(View.ERROR, request, response);
    }

    logRequestEnd(start, response);

  }


  /**
   * Handles all requests to this controller, and delegates them to more specific handlers.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @throws HttpException if an exception state is encountered that would typically return a HTTP
   * status code.
   */
  protected abstract void handleRequest(HttpServletRequest request, HttpServletResponse response)
      throws HttpException, ServletException, IOException;


  /**
   * Parses a request URL and returns an array of parameters encoded in the URL.
   *
   * @param request HTTP request object.
   * @return An array of params.
   */
  protected String[] parseUrlParams(HttpServletRequest request) {

    // Retrieve tokens
    String[] tokens = request.getRequestURI().split("/");

    // Trim servlet name and web app name


  }


  /**
   * Logs the start of a HTTP request. Use the returned long to track how long the request lasts.
   *
   * @param request HTTP request object.
   * @return The current time in milliseconds.
   */
  private long logRequestStart(HttpServletRequest request) {

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
  private void logRequestEnd(long startTime, HttpServletResponse response) {

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
  private void logParameters(Map<String, String[]> params) {

    // Ensure params are not empty
    if (params.isEmpty()) {
      return;
    }

    StringJoiner joiner = new StringJoiner(", ", "{", "}");

    // Iterate over params
    for (String key : params.keySet()) {
      joiner.add(String.format("%s => %s", key, getParamString(params.get(key))));
    }

    LOGGER.fine("Parameters %s", joiner.toString());

  }


  /**
   * Takes an array of params, and returns their string form.
   *
   * @param params An array of parameters.
   * @return String form of paramater array.
   * @see #logParameters(Map)
   */
  private String getParamString(String[] params) {

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
