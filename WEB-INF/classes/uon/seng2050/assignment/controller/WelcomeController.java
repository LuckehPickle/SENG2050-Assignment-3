package uon.seng2050.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.annotation.Action;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.exception.HttpStatusCode;
import uon.seng2050.assignment.model.User;
import uon.seng2050.assignment.model.User.Role;

/**
 * A controller which manages requests to the index of the website.
 *
 * @see AuthenticatedController
 * @since 2018-05-28
 */
@WebServlet(urlPatterns = "")
public class WelcomeController extends AuthenticatedController {


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

    super.handleRequest(request, response);

    // Authenticate user
    if (authenticate(request, response)) {
      route(this, request, response);
    }

  }


  /**
   * Render the index page.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(route = "/?")
  private void handleIndex(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, HttpException {

    User user = (User) request.getAttribute("currentUser");

    if (user.getRole().equals(Role.IT_STAFF.name())) {
      redirect("/issues", request, response);
    } else {
      redirect("/articles", request, response);
    }

  }

}
