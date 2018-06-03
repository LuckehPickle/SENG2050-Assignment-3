package uon.seng2050.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.exception.MethodNotAllowedException;

/**
 * A controller which handles all requests related to issues.
 *
 * @see AuthenticatedController
 * @since 2018-05-29
 */
@WebServlet(urlPatterns = {"/issues", "/issues/*"})
public class IssueController extends AuthenticatedController {


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

    // Call super first to authenticate user
    super.handleRequest(request, response);

    String method = request.getMethod();
    String[] tokens = request.getRequestURI().split("/");

    switch (method) {
      case "GET":
        if (tokens.length == 2) {
          renderIndex(request, response);
        } else {
          if (tokens[2].equals("new")) {
            renderNew(request, response);
          } else {
            renderIssue(tokens[2], request, response);
          }
        }
        break;
      default:
        throw new MethodNotAllowedException(method);
    }

  }


  /**
   * Renders to index page. GET /issues/
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  private void renderIndex(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    render(View.ISSUES, request, response);
  }


  /**
   * Renders a new issue page. GET /issues/new
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  private void renderNew(HttpServletRequest request, HttpServletResponse response) {

  }


  /**
   * Renders a particular issue. GET /issue/:id
   *
   * @param id The desired issue id, taken from the request URL.
   * @param request HTTP request object
   * @param response HTTP response object
   */
  private void renderIssue(String id, HttpServletRequest request,
      HttpServletResponse response) {

  }

}
