package uon.seng2050.assignment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.exception.HttpException;

/**
 * A controller that forces uses to be authenticated before accessing any of it's contents.
 *
 * @see Controller
 * @since 2018-05-28
 */
abstract class AuthenticatedController extends Controller {


  /**
   * Handles all requests to this controller, and delegates them to more specific handlers.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @throws HttpException if an exception state is encountered that would typically return a HTTP
   * status code.
   */
  @Override
  protected void handleRequest(HttpServletRequest request, HttpServletResponse response)
      throws HttpException {

  }

}
