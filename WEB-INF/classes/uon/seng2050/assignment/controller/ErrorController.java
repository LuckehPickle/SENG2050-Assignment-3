package uon.seng2050.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.util.Logger;
import uon.seng2050.assignment.util.PageUtil;

/**
 * A controller for managing thrown HTTP exceptions.
 *
 * @see HttpException
 * @since 2018-05-23
 */
@WebServlet(urlPatterns = "/error")
public class ErrorController extends HttpServlet {

  private static final String EXCEPTION = "javax.servlet.error.exception";


  /**
   * Handle all HTTP requests to /error
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Get exception
    Throwable throwable = (Throwable) request.getAttribute(EXCEPTION);

    // Ensure HttpException was thrown
    if (!(throwable instanceof HttpException)) {
      throw new ServletException("Only HttpExceptions should be thrown to this controller.");
    }

    HttpException exception = (HttpException) throwable;

    // Show error page
    response.setStatus(exception.getStatusCode());
    request.setAttribute("message", exception.getMessage());
    PageUtil.render(View.ERROR, request, response);

    Controller.logRequestEnd(exception.getRequestStart(), response);

  }

}
