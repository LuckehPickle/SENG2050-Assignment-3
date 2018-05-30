package uon.seng2050.assignment;

import uon.seng2050.assignment.util.PageUtil;

/**
 * An enum of all views contained within this project.
 *
 * @see PageUtil
 * @since 2018-05-21
 */
public enum View {

  INDEX("index"),
  LOGIN("session/login"),
  ISSUES("issues/index"),
  NEW_ISSUE("issues/new"),
  ERROR("error");

  private static final String PATH_FORMAT = "/WEB-INF/views/%s.jsp";

  private final String path;

  /**
   * Constructs a new view template.
   *
   * @param path Path to the given JSP
   */
  View(String path) {
    this.path = path;
  }

  public String getPath() {
    return String.format(PATH_FORMAT, path);
  }

}
