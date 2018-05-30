package uon.seng2050.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.exception.MethodNotAllowedException;

/**
 * A controller for handling Comments.
 *
 * @see AuthenticatedController
 * @since 2018-05-28
 */
@WebServlet(urlPatterns = "/comments")
public class CommentController extends AuthenticatedController {


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

    // Call super to authenticate user
    super.handleRequest(request, response);

    String method = request.getMethod();

    switch (method) {
      case "POST":
        handleCreate(request, response);
        break;
      case "PATCH":
      case "PUT":
        handleUpdate(request, response);
        break;
      default:
        throw new MethodNotAllowedException(method);
    }

  }


  /**
   * Handles all POST requests to /comment/:id
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  private void handleCreate(HttpServletRequest request, HttpServletResponse response) {

  }


  /**
   * Handles all PATCH/PUT requests to /comment/:id
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  private void handleUpdate(HttpServletRequest request, HttpServletResponse response) {

  }

}
