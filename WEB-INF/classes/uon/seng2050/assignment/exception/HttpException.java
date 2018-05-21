package uon.seng2050.assignment.exception;

/**
 * An exception that can be thrown whenever a HTTP error code should be returned.
 *
 * @see HttpStatusCode
 * @since 2018-05-21
 */
public class HttpException extends Throwable {

  private int statusCode;


  /**
   * Constructs a new HTTP Exception.
   *
   * @param statusCode HTTP status code to display.
   * @param message Exception message.
   */
  @SuppressWarnings("unused")
  public HttpException(int statusCode, String message) {
    super(message);
    this.statusCode = statusCode;
  }


  /**
   * Constructs a new HTTP Exception.
   *
   * @param statusCode HTTP status code to display.
   * @param message Exception message.
   */
  public HttpException(HttpStatusCode statusCode, String message) {
    super(message);
    this.statusCode = statusCode.getCode();
  }


  public int getStatusCode() {
    return statusCode;
  }

}
