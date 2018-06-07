package uon.seng2050.assignment.controller;

import io.seanbailey.adapter.Model;
import io.seanbailey.adapter.exception.SQLAdapterException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.model.User;
import uon.seng2050.assignment.util.Logger;

/**
 * A controller that forces uses to be authenticated before accessing any of it's contents.
 *
 * @see Controller
 * @see ActionController
 * @since 2018-05-28
 */
abstract class AuthenticatedController extends ActionController {

  private static Logger LOGGER = new Logger();


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
      throws HttpException, ServletException, IOException {

    // Retrieve session
    HttpSession session = request.getSession();

    if (session.getAttribute("userId") == null) {
      LOGGER.fine("user id null");
      return;
    }

    // Retrieve matching user
    List<Model> users = null;
    try {
      users = Model.find(User.class, "id", session.getAttribute("userId")).execute();
    } catch (SQLException | SQLAdapterException e) {
      e.printStackTrace();
      return;
    }

    // Make sure user exists
    if (users.isEmpty()) {
      session.invalidate();
      redirect("/", request, response);
      return;
    }

    // Retrieve user and set as request attribute
    User currentUser = (User) users.get(0);
    request.setAttribute("currentUser", currentUser);

  }


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
