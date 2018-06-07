package uon.seng2050.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uon.seng2050.assignment.exception.HttpException;

/**
 * A controller that forces uses to be authenticated before accessing any of it's contents.
 *
 * @see Controller
 * @see ActionController
 * @since 2018-05-28
 */
abstract class AuthenticatedController extends ActionController {


  /**
   * Ensure that the user is logged in.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @return Whether the user is logged in
   */
  protected boolean authenticate(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    // Get session
    HttpSession session = request.getSession();

    // Check if user is not logged in
    if (session.getAttribute("userId") == null) {
      redirect("/session/login", request, response);
      return false;
    }

    return true;

  }

}
