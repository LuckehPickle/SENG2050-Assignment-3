package uon.seng2050.assignment.controller;

import io.seanbailey.adapter.Model;
import io.seanbailey.adapter.exception.SQLAdapterException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.annotation.Action;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.exception.HttpStatusCode;
import uon.seng2050.assignment.model.Article;

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

    List<Model> articles = Model
        .all(Article.class)
        .page(request.getParameter("page"))
        .per(25)
        .execute();

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
          "Could not find an issue with the id " + id);
    }

    request.setAttribute("article", articles.get(0));
    render(View.ARTICLE, request, response);
  }


  /**
   * Publishes an article.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(methods = "POST", route = "/articles")
  private void publish(HttpServletRequest request, HttpServletResponse response) {

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

}