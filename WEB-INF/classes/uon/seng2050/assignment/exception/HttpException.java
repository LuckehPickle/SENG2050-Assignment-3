package uon.seng2050.assignment.exception;

import javax.servlet.ServletException;

/**
 * An exception that can be thrown whenever a HTTP error code should be returned.
 *
 * @see HttpStatusCode
 * @see ServletException
 * @since 2018-05-21
 */
public class HttpException extends ServletException {

  private int statusCode;
  private long requestStart;


  /**
   * Constructs a new HTTP Exception.
   *
   * @param statusCode HTTP status code to display.
   * @param requestStart Time that the request started.
   * @param message Exception message.
   */
  @SuppressWarnings({"unused", "WeakerAccess"})
  public HttpException(int statusCode, long requestStart, String message) {
    super(message);
    this.statusCode = statusCode;
    this.requestStart = requestStart;
  }


  /**
   * Constructs a new HTTP Exception.
   *
   * @param statusCode HTTP status code to display.
   * @param requestStart Time that the request started.
   * @param message Exception message.
   */
  public HttpException(HttpStatusCode statusCode, long requestStart, String message) {
    this(statusCode.getCode(), requestStart, message);
  }


  public int getStatusCode() {
    return statusCode;
  }

  public long getRequestStart() {
    return requestStart;
  }

}
