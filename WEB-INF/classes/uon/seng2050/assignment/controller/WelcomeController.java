package uon.seng2050.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.util.PageUtil;

/**
 * A controller which manages requests to the index of the website.
 *
 * @since 2018-05-21
 */
@WebServlet(urlPatterns = "")
public class WelcomeController extends HttpServlet {


  /**
   * Handle GET requests to /
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PageUtil.render(View.INDEX, request, response);
  }

}
