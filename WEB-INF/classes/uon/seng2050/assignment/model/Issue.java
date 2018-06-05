package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import java.util.UUID;

public class Issue extends Model {

  private UUID id;
  private Category category;
  private SubCategory subCategory;
  private State state;
  private String title;
  private String body;
  private boolean locked;


  /**
   * Default constructor. Set any defaults here. Note: All primitives must have a default.
   */
  public Issue() {
    locked = false;
  }


  /**
   * An enum which represents the current state of this issue.
   *
   * @see java.lang.Enum
   */
  @SuppressWarnings("unused")
  public enum State {
    NEW, IN_PROGRESS, COMPLETED, RESOLVED
  }


  /**
   * An enum which represents the category of this issue.
   *
   * @see java.lang.Enum
   */
  @SuppressWarnings("unused")
  public enum Category {
    NETWORK, SOFTWARE, HARDWARE, EMAIL, ACCOUNT, OTHER
  }


  /**
   * An enum which represents the subcategory of this issue.
   *
   * @see java.lang.Enum
   */
  @SuppressWarnings("unused")
  public enum SubCategory {
    CANT_CONNECT, SPEED, CONSTANT_DROPOUTS, SLOW_TO_LOAD, WONT_LOAD, WONT_BOOT, BLUE_SCREEN,
    DISK_DRIVE, PERIPHERALS, CANT_SEND, CANT_RECEIVE, SPAM, PASSWORD_RESET, WRONG_DETAILS, OTHER
  }


  /**
   * Attempts to validate the model before any database operations are carried out. Also, be sure to
   * include an errors using addError(). Errors will be shown to the user on forms.
   *
   * @return Whether this model is considered valid.
   * @see #beforeValidate()
   * @see #afterValidate()
   * @see #addError(String)
   * @since 2018-05-14
   */
  @Override
  public boolean validate() {
    return false;
  }


  //GET/SET
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public SubCategory getSubCategory() {
    return subCategory;
  }

  public void setSubCategory(SubCategory subCategory) {
    this.subCategory = subCategory;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public boolean isLocked() {
    return locked;
  }

  public void setLocked(boolean locked) {
    this.locked = locked;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

}
