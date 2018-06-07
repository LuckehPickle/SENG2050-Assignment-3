package uon.seng2050.assignment;

import uon.seng2050.assignment.util.PageUtil;

/**
 * An enum of all views contained within this project.
 *
 * @see PageUtil
 * @since 2018-05-21
 */
@SuppressWarnings("unused")
public enum View {

  WELCOME("index"),
  LOGIN("session/login"),
  ISSUES("issues/index"),
  ISSUE("issues/show"),
  NEW_ISSUE("issues/new"),
  EDIT_ISSUE("issues/edit"),
  ARTICLES("articles/index"),
  ARTICLE("articles/show"),
  EDIT_ARTICLE("articles/edit"),
  MAINTENANCE("maintenance/index"),
  NEW_MAINTENANCE("maintenance/new"),
  EDIT_MAINTENANCE("maintenance/edit"),
  ERROR("shared/error");

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
