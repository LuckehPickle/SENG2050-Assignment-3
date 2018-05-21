package uon.seng2050.assignment.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.exception.HttpException;

/**
 * A utility class for rendering various views throughout this application.
 *
 * @see View
 * @since 2018-05-21
 */
public class PageUtil {

  private static Logger LOGGER = Logger.getLogger(PageUtil.class.getSimpleName());


  /**
   * Renders a particular view, within the context of a HTTP request and response.
   *
   * @param view The view that should be rendered.
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  public static void render(View view, HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    LOGGER.log(Level.INFO, "Rendering view {0}", new Object[]{ view.getPath() });
    request.getRequestDispatcher(view.getPath()).forward(request, response);
  }


  /**
   * Renders a standard error page according to the particular status code that is thrown.
   *
   * @param exception HTTP Exception that was thrown. Contains a HTTP status code.
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  public static void renderError(HttpException exception, HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    // Set the error code and status
    response.setStatus(exception.getStatusCode());
    request.setAttribute("message", exception.getMessage());

    render(View.ERROR, request, response);

  }

}
