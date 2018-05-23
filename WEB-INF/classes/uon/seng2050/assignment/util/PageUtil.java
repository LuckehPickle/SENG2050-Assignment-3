package uon.seng2050.assignment.util;

import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;

/**
 * A utility class for rendering various views throughout this application.
 *
 * @see View
 * @since 2018-05-21
 */
public class PageUtil {

  private static Logger LOGGER = new Logger();


  /**
   * Renders a particular view, within the context of a HTTP request and response.
   *
   * @param view The view that should be rendered.
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  public static void render(View view, HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    LOGGER.fine("Rendering %s", view.getPath());
    request.getRequestDispatcher(view.getPath()).forward(request, response);

  }

}
