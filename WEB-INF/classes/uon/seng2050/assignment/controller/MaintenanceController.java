package uon.seng2050.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.View;
import uon.seng2050.assignment.annotation.Action;
import uon.seng2050.assignment.exception.HttpException;

@WebServlet(urlPatterns = {"/maintenance", "/maintenance/*"})
public class MaintenanceController extends AuthenticatedController {


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

    // Authenticate user
    if (authenticate(request, response)) {
      route(this, request, response);
    }

  }


  /**
   * Renders all maintenance events.
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   * @param params URL parameters.
   */
  @Action(route = "/maintenance/?")
  private void renderIndex(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    render(View.MAINTENANCE, request, response);
  }


  /**
   * Renders a page for creating a new maintenance event.
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   * @param params URL parameters.
   */
  @Action(route = "/maintenance/new")
  private void renderNew(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    render(View.NEW_MAINTENANCE, request, response);
  }


  /**
   * Creates a new maintenance event.
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   * @param params URL parameters.
   */
  @Action(methods = "POST", route = "/maintenance")
  private void createMaintenanceEvent(HttpServletRequest request, HttpServletResponse response) {

  }


  /**
   * Renders a page for editing an existing maintenance event.
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  @Action(route = "/maintenance/:id;/edit")
  private void renderEdit(HttpServletRequest request, HttpServletResponse response, String id)
      throws ServletException, IOException {
    render(View.EDIT_MAINTENANCE, request, response);
  }


  /**
   * Edits an existing maintenance event.
   *
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  @Action(methods = {"PATCH", "PUT"}, route = "/maintenance/:id;")
  private void updateMaintenanceEvent(HttpServletRequest request, HttpServletResponse response,
      String id) {

  }

}
