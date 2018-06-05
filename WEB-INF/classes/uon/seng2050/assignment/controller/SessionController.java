package uon.seng2050.assignment.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.annotation.Action;
import uon.seng2050.assignment.exception.HttpException;

/**
 * A controller that handles logging in/logging out.
 *
 * @see Controller
 * @since 2018-05-21
 */
@WebServlet(urlPatterns = {"/session", "/session/*"})
public class SessionController extends ActionController {


  /**
   * Handles all requests to this controller, and delegates them to more specific handlers.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Override
  protected void handleRequest(HttpServletRequest request, HttpServletResponse response)
      throws HttpException {
    route(this, request, response);
  }


  /**
   * Renders the login view.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @param params URL parameters.
   */
  @Action(route = "/session/login")
  private void renderLogin(HttpServletRequest request, HttpServletResponse response,
      List<String> params) throws ServletException, IOException {

    // TODO Ensure the user is not already logged in
    render(View.LOGIN, request, response);
  }


  /**
   * Log the user in.
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   * @param params URL parameters.
   */
  @Action(methods = "POST", route = "/session")
  private void handleLogin(HttpServletRequest request, HttpServletResponse response,
      List<String> params) {

  }


  /**
   * Handles all DELETE requests to /authentication
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   * @param params URL parameters.
   */
  private void handleLogout(HttpServletRequest request, HttpServletResponse response,
      List<String> params) {

  }

}
