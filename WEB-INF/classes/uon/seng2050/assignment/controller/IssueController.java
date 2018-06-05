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

    // Route to a particular action
    route(this, request, response);

  }


  /**
   * Renders the index page.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @param params URL parameters.
   */
  @Action(route = "/issues/?")
  private void renderIndex(HttpServletRequest request, HttpServletResponse response,
      List<String> params) throws ServletException, IOException {

    render(View.ISSUES, request, response);
  }


  /**
   * Renders a particular issue.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @param params URL parameters.
   */
  @Action(route = "/issues/:id;")
  private void renderIssue(HttpServletRequest request, HttpServletResponse response,
      List<String> params) throws ServletException, IOException {

    render(View.ISSUE, request, response);
  }


  /**
   * Renders a new issue page.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @param params URL parameters.
   */
  @Action(route = "/issues/new")
  private void renderNew(HttpServletRequest request, HttpServletResponse response,
      List<String> params) throws ServletException, IOException {
    render(View.NEW_ISSUE, request, response);
  }


  /**
   * Creates a new issue.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @param params URL parameters.
   */
  @Action(methods = "POST", route = "/issues")
  private void createIssue(HttpServletRequest request, HttpServletResponse response,
      List<String> params) {

  }


  /**
   * Renders a page for editing issues.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @param params URL parameters.
   */
  @Action(route = "/issues/:id;/edit")
  private void renderEdit(HttpServletRequest request, HttpServletResponse response,
      List<String> params) throws ServletException, IOException {
    render(View.EDIT_ISSUE, request, response);
  }


  /**
   * Updates an existing issues.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @param params URL parameters.
   */
  @Action(methods = {"PATCH", "PUT"}, route = "/issues/:id;")
  private void updateIssue(HttpServletRequest request, HttpServletResponse response,
      List<String> params) {

  }

}
