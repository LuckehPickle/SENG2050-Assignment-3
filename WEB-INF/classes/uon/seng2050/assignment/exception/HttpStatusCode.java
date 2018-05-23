package uon.seng2050.assignment.exception;

/**
 * An enum of all HTTP status codes, that can be used in the HttpException.
 *
 * @see HttpException
 * @since 2018-05-21
 */
@SuppressWarnings("unused")
public enum HttpStatusCode {

  OK(200),
  REDIRECT(307),
  BAD_REQUEST(400),
  FORBIDDEN(403),
  PAGE_NOT_FOUND(404),
  METHOD_NOT_ALLOWED(405),
  INTERNAL_SERVER_ERROR(500);

  private int code;


  /**
   * Creates a new HTTP status code.
   *
   * @param code HTTP status code.
   */
  HttpStatusCode(int code) {
    this.code = code;
  }


  /**
   * Searches for a status code with the given code. Null of not found.
   *
   * @param code Status code to search for.
   * @return Matching HttpStatusCode
   */
  public static HttpStatusCode fromCode(int code) {

    // Iterate over defined status codes
    for (HttpStatusCode value : HttpStatusCode.values()) {
      if (value.getCode() == code) {
        return value;
      }
    }

    return null;

  }


  public int getCode() {
    return code;
  }

  public String getShortName() {
    return this.name().replace("_", " ");
  }

}
