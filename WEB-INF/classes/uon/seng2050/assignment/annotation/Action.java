package uon.seng2050.assignment.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation which declares an action in a controller.
 *
 * @see uon.seng2050.assignment.controller.Controller
 * @see java.lang.annotation.Annotation
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {

  /**
   * @return A list of methods.
   */
  String[] methods() default {"GET"};

  /**
   * @return A regex pattern that should match the given route.
   */
  String route() default "/";

}
