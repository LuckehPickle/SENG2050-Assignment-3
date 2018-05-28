package uon.seng2050.assignment.exception;

/**
 * An exception that can be thrown when an unsupported HTTP method is used.
 *
 * @see HttpException
 * @see HttpStatusCode#METHOD_NOT_ALLOWED
 * @since 2018-05-28
 */
public class MethodNotAllowedException extends HttpException {

  /**
   * Constructs a new HTTP Exception.
   *
   * @param method HTTP request method.
   */
  public MethodNotAllowedException(String method) {
    super(HttpStatusCode.METHOD_NOT_ALLOWED,
        String.format("Sorry, you cannot use the %s method here.", method));
  }

}
