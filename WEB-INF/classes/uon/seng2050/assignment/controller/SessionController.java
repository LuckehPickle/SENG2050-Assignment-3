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
import javax.servlet.http.HttpSession;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.annotation.Action;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.exception.HttpStatusCode;
import uon.seng2050.assignment.model.User;
import uon.seng2050.assignment.util.Logger;
import uon.seng2050.assignment.util.PageUtil;

/**
 * A controller that handles logging in/logging out.
 *
 * @see Controller
 * @since 2018-05-21
 */
@WebServlet(urlPatterns = {"/session", "/session/*"})
public class SessionController extends ActionController {

  private static Logger LOGGER = new Logger();


  /**
   * Handles all requests to this controller, and delegates them to more specific handlers.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Override
  protected void handleRequest(HttpServletRequest request, HttpServletResponse response)
      throws HttpException {
    route(this, request, response);
  }


  /**
   * Renders the login view.
   *
   * @param request HTTP request object
   * @param response HTTP response object
   */
  @Action(route = "/session/login")
  private void renderLogin(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();

    // Ensure user is not already logged in
    if (session.getAttribute("userId") != null) {
      redirect("/", request, response);
    }

    render(View.LOGIN, request, response);

  }


  /**
   * Log the user in.
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  @Action(methods = "POST", route = "/session")
  private void handleLogin(HttpServletRequest request, HttpServletResponse response)
      throws HttpException, SQLException, SQLAdapterException, ServletException, IOException {

    // Get credentials
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Validate presence
    if (username == null || password == null) {
      throw new HttpException(HttpStatusCode.BAD_REQUEST, "Missing username or password.");
    }

    List<Model> users = Model.find(User.class, "username", username).execute();

    // No user found
    if (users.isEmpty()) {
      request.setAttribute("message", "We couldn't find a user named '" + username + "'.");
      render(View.LOGIN, request, response);
      return;
    }

    // Check password
    User user = (User) users.get(0);
    if (!user.getPassword().equals(password)) {
      request.setAttribute("message", "Sorry, that password is incorrect.");
      render(View.LOGIN, request, response);
      return;
    }

    // Save to session
    HttpSession session = request.getSession();
    session.setAttribute("userId", user.getId());
    LOGGER.fine("User authenticated as %s", user.getFullName());

    redirect("/", request, response);

  }


  /**
   * Handles all DELETE requests to /authentication
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  @Action(methods = "DELETE", route = "/session")
  private void handleLogout(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    HttpSession session = request.getSession();

    // Ensure user is not already logged in
    if (session.getAttribute("userId") == null) {
      redirect("/session/login", request, response);
      return;
    }

    LOGGER.fine("Logging out user.");
    session.invalidate();
    redirect("/session/login", request, response);

  }

}
