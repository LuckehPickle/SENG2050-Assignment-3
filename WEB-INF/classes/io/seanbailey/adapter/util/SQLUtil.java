package io.seanbailey.adapter.util;

public class SQLUtil {

  /**
   * Determines the table name for a given model.
   *
   * @param clazz Model class.
   * @return Table name of the given model.
   */
  public static String getTableName(Class<?> clazz) {
    return StringUtil.toPluralForm(clazz.getSimpleName());
  }

}
