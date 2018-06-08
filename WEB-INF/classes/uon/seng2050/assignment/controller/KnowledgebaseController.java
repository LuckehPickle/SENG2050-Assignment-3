package uon.seng2050.assignment.controller;

import io.seanbailey.adapter.Model;
import io.seanbailey.adapter.SQLChain;
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
import uon.seng2050.assignment.model.Article;
import uon.seng2050.assignment.model.Comment;
import uon.seng2050.assignment.model.Issue;
import uon.seng2050.assignment.model.Issue.State;
import uon.seng2050.assignment.model.User;
import uon.seng2050.assignment.model.User.Role;
import uon.seng2050.assignment.util.Logger;

@WebServlet(urlPatterns = {"/articles", "/articles/*"})
public class KnowledgebaseController extends AuthenticatedController {


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
  @Action(route = "/articles/?")
  private void renderIndex(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, SQLException, SQLAdapterException {

    SQLChain chain = Model.all(Article.class);

    String category = request.getParameter("category");
    String subCategory = request.getParameter("subcategory");

    if (category != null) {
      chain = chain.where("category", category);
    }

    if (subCategory != null) {
      chain = chain.where("subcategory", subCategory);
    }

    List<Model> articles = chain.execute();

    request.setAttribute("articles", articles);
    render(View.ARTICLES, request, response);
  }


  /**
   * Renders a particular article.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(route = "/articles/:id;")
  private void renderArticle(HttpServletRequest request, HttpServletResponse response, String id)
      throws ServletException, IOException, HttpException, SQLException, SQLAdapterException {

    List<Model> articles = Model.find(Article.class, "id", id).execute();

    // Ensure result set is not empty
    if (articles.isEmpty()) {
      throw new HttpException(HttpStatusCode.PAGE_NOT_FOUND,
          "Could not find an article with the id " + id);
    }

    Article article = (Article) articles.get(0);
    request.setAttribute("article", article);
    render(View.ARTICLE, request, response);
  }


  /**
   * Publishes an article.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(methods = "POST", route = "/articles")
  private void publish(HttpServletRequest request, HttpServletResponse response)
      throws HttpException, SQLException, SQLAdapterException, IOException, ServletException {

    // Issue id
    String issueId = request.getParameter("issueId");

    // Ensure issue id was given
    if (issueId == null) {
      throw new HttpException(HttpStatusCode.BAD_REQUEST, "No issue id given.");
    }

    // Retrieve all issues
    List<Model> issues = Model.find(Issue.class, "id", issueId).execute();

    // Ensure issue exists
    if (issues.isEmpty()) {
      throw new HttpException(HttpStatusCode.PAGE_NOT_FOUND, "No issue was found with the id " + issueId);
    }

    // Retrieve issue
    Issue issue = (Issue) issues.get(0);
    User user = (User) request.getAttribute("currentUser");

    // Ensure user is staff
    if (!user.getRole().equals(Role.IT_STAFF.name())) {
      throw new HttpException(HttpStatusCode.FORBIDDEN, "Only IT Staff can publish articles.");
    }

    // Ensure issue is publishable
    if (!issue.getState().equals(State.COMPLETED.name())) {
      throw new HttpException(HttpStatusCode.BAD_REQUEST, "This issue is not completed yet.");
    }

    // Ensure issue has answer
    if (issue.getAnswerId() == null) {
      throw new HttpException(HttpStatusCode.BAD_REQUEST, "This issue has not yet been answered.");
    }

    // Ensure issue has answer
    List<Model> comments = Model.find(Comment.class, "id", issue.getAnswerId()).execute();

    if (comments.isEmpty()) {
      throw new HttpException(HttpStatusCode.BAD_REQUEST, "This issue's comment doesn't exist.");
    }

    Comment answer = (Comment) comments.get(0);

    Article article = new Article();
    article.setId(UUID.randomUUID().toString());
    article.setAnswer(answer.getBody());
    article.setTitle(issue.getTitle());
    article.setBody(issue.getBody());
    article.setCategory(issue.getCategory());
    article.setSubCategory(issue.getSubCategory());
    article.setPublisher(user.getFullName());

    if (article.save()) {
      redirect("/articles/" + article.getId(), request, response);
    } else {
      request.setAttribute("errors", article.getErrors());
      request.setAttribute("issue", issue);
      render(View.ISSUE, request, response);
    }

  }


  /**
   * Renders a page for editing an article.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(route = "/articles/:id;/edit")
  private void renderEdit(HttpServletRequest request, HttpServletResponse response, String id)
      throws ServletException, IOException {
    render(View.EDIT_ARTICLE, request, response);
  }


  /**
   * Updates an existing knowledgebase article.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(methods = {"PATCH", "PUT"}, route = "/articles/:id;")
  private void updateArticle(HttpServletRequest request, HttpServletResponse response, String id) {

  }

  @Action(methods = "POST", route = "/articles/:id;")
  private void addHelp(HttpServletRequest request, HttpServletResponse response, String id)
      throws ServletException, IOException, HttpException, SQLException, SQLAdapterException {

    List<Model> articles = Model.find(Article.class, "id", id).execute();

    if (articles.isEmpty()) {
      throw new HttpException(HttpStatusCode.PAGE_NOT_FOUND,
          "Could not find an article with the id " + id);
    }

    request.setAttribute("article", articles.get(0));
    Article article = (Article) articles.get(0);
    article.addHelpful();
    article.update();
    throw new HttpException(HttpStatusCode.BAD_REQUEST, "hey");
  }

}