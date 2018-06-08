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
import uon.seng2050.assignment.model.Comment;
import uon.seng2050.assignment.model.Issue;
import uon.seng2050.assignment.model.User;

/**
 * A controller for handling Comments.
 *
 * @see AuthenticatedController
 * @since 2018-05-28
 */
@WebServlet(urlPatterns = {"/comments", "/comments/*"})
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

    super.handleRequest(request,response);

    // Authenticate user
    if (authenticate(request, response)) {
      route(this, request, response);
    }

  }


  /**
   * Handles all POST requests to /comments/:id
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(methods = "POST", route = "/comments/:id;")
  private void handleCreate(HttpServletRequest request, HttpServletResponse response, String id)
      throws SQLException, SQLAdapterException, HttpException, IOException, ServletException {

    // Retrieve current user
    User user = (User) request.getAttribute("currentUser");
    Comment comment = new Comment();
    Issue issue;
    List<Model> issues = Model.find(Issue.class, "id", id).execute();

    // Ensure issue exists
    if (issues.isEmpty()) {
      throw new HttpException(HttpStatusCode.PAGE_NOT_FOUND, "Could not find an issue with the id " + id + ".");
    }

    issue = (Issue) issues.get(0);
    comment.setId(UUID.randomUUID().toString());
    comment.setIssueId(issue.getId());
    comment.setAuthorId(user.getId());
    comment.setBody(request.getParameter("comment").trim());

    if (comment.save()) {
      redirect("/issues/" + issue.getId(), request, response);
    } else {
      request.setAttribute("errors", comment.getErrors());
      request.setAttribute("issue", issue);
      render(View.ISSUE, request, response);
    }

  }


  /**
   * Handles all PATCH/PUT requests to /comments/:id
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(methods = {"PATCH", "PUT"}, route = "/comments/:id;")
  private void handleUpdate(HttpServletRequest request, HttpServletResponse response, String id) {

  }

}
