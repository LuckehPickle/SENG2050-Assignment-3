package uon.seng2050.assignment.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uon.seng2050.assignment.annotation.Action;
import uon.seng2050.assignment.exception.HttpException;
import uon.seng2050.assignment.exception.HttpStatusCode;
import uon.seng2050.assignment.util.Logger;

/**
 * A controller populated with actions. All controllers should extend from this, if they want to
 * make use of the @Action annotation and the route() function.
 *
 * @see uon.seng2050.assignment.annotation.Action
 * @see #route(ActionController, HttpServletRequest, HttpServletResponse)
 */
abstract class ActionController extends Controller {


  private static Logger LOGGER = new Logger();
  private static final Pattern GROUP_PATTERN;

  static {
    GROUP_PATTERN = Pattern.compile(Matcher.quoteReplacement("(\\?<\\w+>)"));
  }


  /**
   * Routes a request to an action. Actions must be annotated with @Action
   *
   * @param controller Controller containing actions.
   * @param request HTTP request object.
   * @param response HTTP response object.
   */
  void route(ActionController controller, HttpServletRequest request,
      HttpServletResponse response) throws HttpException {

    String url = request.getRequestURI();

    // Iterate over actions until we find one that matches
    Method[] methods = controller.getClass().getDeclaredMethods();
    for (Method method : methods) {

      Action action = getActionAnnotation(method);

      // Ensure annotation was found
      if (action == null || !matchesMethod(action, request.getMethod())) {
        continue;
      }

      // Parse action route, and create REGEX pattern.
      String regex = parseRoute(action);
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(url);

      // Test if matches
      if (!matcher.matches()) {
        continue;
      }

      LOGGER.fine(
          "Mapping request to %s#%s",
          controller.getClass().getSimpleName(),
          method.getName()
      );

      try {
        method.setAccessible(true);
        method.invoke(controller, request, response, getUrlParams(matcher));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        if (e.getCause() instanceof HttpException) {
          throw (HttpException) e.getCause();
        }
        e.printStackTrace();
      }

      return;

    }

    LOGGER.fine("Could not map request to an action.");
    throw new HttpException(HttpStatusCode.PAGE_NOT_FOUND, "Sorry! We couldn't find that page.");

  }


  /**
   * Attempts to retrieve the action annotation of a given method.
   *
   * @param method Method to check for annotation.
   * @return Action annotation or null.
   */
  private Action getActionAnnotation(Method method) {

    // Iterate over annotations
    for (Annotation annotation : method.getDeclaredAnnotations()) {
      if (annotation instanceof Action) {
        return (Action) annotation;
      }
    }

    return null;

  }


  /**
   * Determines whether the given method should be matched by this action.
   *
   * @param action Action annotation.
   * @param method HTTP method.
   * @return Whether the given action matches the given method.
   */
  private boolean matchesMethod(Action action, String method) {

    // Iterate over supported methods
    for (String supportedMethod : action.methods()) {
      if (supportedMethod.equalsIgnoreCase(method)) {
        return true;
      }
    }

    return false;

  }


  /**
   * Parses an actions route, and returns a REGEX pattern.
   *
   * @param action Action annotation.
   * @return A REGEX pattern.
   */
  private String parseRoute(Action action) {

    // Allow webapp name
    String route = "^/[\\w-]+" + action.route();

    // Escape any forward slashes
    route = route.replaceAll("/", Matcher.quoteReplacement("\\/"));

    // Add matching groups
    route = route
        .replaceAll(":", "(?<")
        .replaceAll(";", Matcher.quoteReplacement(">[\\w-]+)"));

    // Ensure end is matched
    route = route + "$";

    return route;

  }


  /**
   * Iterates over matched groups, and adds them to a list of params.
   *
   * @param matcher Regex matcher.
   * @return A list of matched url patterns.
   */
  private List<String> getUrlParams(Matcher matcher) {

    List<String> params = new ArrayList<>();

    while(matcher.find()) {
      LOGGER.info(matcher.group(1));
      params.add(matcher.group(1));
    }

    return params;

  }

}
