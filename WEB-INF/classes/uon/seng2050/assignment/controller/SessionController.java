package uon.seng2050.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.exception.MethodNotAllowedException;
import uon.seng2050.assignment.util.PageUtil;

/**
 * A controller that handles logging in/logging out.
 *
 * @see Controller
 * @since 2018-05-21
 */
@WebServlet(urlPatterns = "/auth")
public class SessionController extends Controller {


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

    String method = request.getMethod();

    switch (method) {
      case "GET":
        renderLogin(request, response);
        break;
      case "POST":
        handleLogin(request, response);
        break;
      case "DELETE":
        handleLogout(request, response);
        break;
      default:
        throw new MethodNotAllowedException(method);
    }

  }


  /**
   * Renders the login view.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  private void renderLogin(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // TODO Ensure the user is not already logged in
    render(View.LOGIN, request, response);
  }


  /**
   * Handles all POST requests to /authentication
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  private void handleLogin(HttpServletRequest request, HttpServletResponse response) {

  }


  /**
   * Handles all DELETE requests to /authentication
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  private void handleLogout(HttpServletRequest request, HttpServletResponse response) {

  }

}
