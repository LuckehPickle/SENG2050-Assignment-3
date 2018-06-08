package uon.seng2050.assignment.controller;

import io.seanbailey.adapter.Model;
import io.seanbailey.adapter.exception.SQLAdapterException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.annotation.Action;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.exception.HttpStatusCode;
import uon.seng2050.assignment.model.Issue;
import uon.seng2050.assignment.model.Issue.State;
import uon.seng2050.assignment.model.User;

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

    super.handleRequest(request, response);

    // Authenticate user
    if (authenticate(request, response)) {
      route(this, request, response);
    }

  }


  /**
   * Renders the index page.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(route = "/issues/?")
  private void renderIndex(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, SQLException, SQLAdapterException {

    List<Model> issues = Model
        .all(Issue.class)
        .page(request.getParameter("page"))
        .per(25)
        .execute();

    request.setAttribute("issues", issues);
    render(View.ISSUES, request, response);

  }


  /**
   * Renders a new issue page.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(route = "/issues/new")
  private void renderNew(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    render(View.NEW_ISSUE, request, response);
  }


  /**
   * Creates a new issue.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(methods = "POST", route = "/issues")
  private void createIssue(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, SQLAdapterException, IOException, ServletException {

    // Create a new issue
    Issue issue = new Issue();
    issue.setId(UUID.randomUUID().toString());
    issue.setTitle(request.getParameter("title"));
    issue.setBody(request.getParameter("body"));
    issue.setCategory(request.getParameter("category"));
    issue.setSubCategory(request.getParameter("subCategory"));
    issue.setAuthorId(((User) request.getAttribute("currentUser")).getId());
    issue.setState(State.NEW.name());

    if (issue.save()) {
      redirect("/issues", request, response);
    } else {
      request.setAttribute("errors", issue.getErrors());
      render(View.NEW_ISSUE, request, response);
    }

  }


  /**
   * Renders a page for editing issues.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @param params URL parameters.
   */
  @Action(route = "/issues/:id;/edit")
  private void renderEdit(HttpServletRequest request, HttpServletResponse response, String id)
      throws ServletException, IOException {
    render(View.EDIT_ISSUE, request, response);
  }


  /**
   * Renders a particular issue.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   * @param id Issue id.
   */
  @Action(route = "/issues/:id;")
  private void renderIssue(HttpServletRequest request, HttpServletResponse response, String id)
      throws ServletException, IOException, SQLException, SQLAdapterException, HttpException {

    // Retrieve issue in question
    List<Model> issues = Model.find(Issue.class, "id", id).execute();

    // Ensure result set is not empty
    if (issues.isEmpty()) {
      throw new HttpException(HttpStatusCode.PAGE_NOT_FOUND,
          "Could not find an issue with the id " + id);
    }

    request.setAttribute("issue", issues.get(0));
    render(View.ISSUE, request, response);

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
