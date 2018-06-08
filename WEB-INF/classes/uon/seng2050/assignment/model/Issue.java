package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import io.seanbailey.adapter.annotation.PrimaryKey;
import io.seanbailey.adapter.exception.SQLAdapterException;
import io.seanbailey.adapter.util.Order;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Issue extends Model {

  @PrimaryKey
  private UUID id;
  private UUID authorId;
  private State state;
  private Category category;
  private SubCategory subCategory;
  private String title;
  private String body;
  private UUID answerId;
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

    boolean valid = true;

    // Validate title length and existence
    if (title == null) {
      addError("Title must exist.");
      valid = false;
    } else if (title.length() > 80) {
      addError("Title must be less than 80 characters long.");
      valid = false;
    } else if (title.length() < 10) {
      addError("Title must be at least 10 characters long.");
      valid = false;
    }

    return valid;

  }


  /**
   * Attempts to retrieve the author of this issue.
   *
   * @return The author of this issue: a user.
   */
  public User getAuthor() {

    // Attempt to find user
    List<Model> users;
    try {
      users = Model.find(User.class, "id", authorId.toString()).execute();
    } catch (SQLException | SQLAdapterException e) {
      return null;
    }

    if (users.isEmpty()) {
      return null;
    } else {
      return (User) users.get(0);
    }

  }


  public Comment getAnswer() {

    List<Model> comments;

    try {
      comments = Model.find(Comment.class, "id", answerId).execute();
    } catch (SQLException | SQLAdapterException e) {
      e.printStackTrace();
      return null;
    }

    if (comments.isEmpty()) {
      return null;
    } else {
      return (Comment) comments.get(0);
    }

  }


  /**
   * Attempts to retrieve all comments related to this issue.
   *
   * @return A list of comments.
   */
  public List<Model> getComments() {

    List<Model> comments = null;

    try {
      comments = Model
          .where(Comment.class, "issueId", getId())
          .order("createdAt", Order.ASCENDING)
          .execute();
    } catch (SQLException | SQLAdapterException e) {
      e.printStackTrace();
    }

    return comments;

  }

  public String getAuthorId() {
    return authorId.toString();
  }

  public void setAuthorId(String authorId) {
    this.authorId = UUID.fromString(authorId);
  }

  public String getId() {
    return id.toString();
  }

  public void setId(String id) {
    this.id = UUID.fromString(id);
  }

  public String getState() {
    return state.name();
  }

  public void setState(String state) {
    this.state = State.valueOf(state);
  }

  public String getCategory() {
    return category.name();
  }

  public void setCategory(String category) {
    this.category = Category.valueOf(category);
  }

  public String getSubCategory() {

    if (subCategory == null) {
      return null;
    }

    return subCategory.name();

  }

  public void setSubCategory(String subCategory) {
    if (subCategory == null) {
      this.subCategory = SubCategory.OTHER;
    } else {
      this.subCategory = SubCategory.valueOf(subCategory);
    }
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

  public String getAnswerId() {
    if (answerId == null) return null;
    return answerId.toString();
  }

  public void setAnswerId(String answerId) {
    this.answerId = UUID.fromString(answerId);
  }

  public boolean isLocked() {
    return locked;
  }

  public void setLocked(boolean locked) {
    this.locked = locked;
  }

  @Override
  public Date getCreatedAt() {
    return super.getCreatedAt();
  }

  @Override
  public void setCreatedAt(Date createdAt) {
    super.setCreatedAt(createdAt);
  }

  @Override
  public Date getUpdatedAt() {
    return super.getUpdatedAt();
  }

  @Override
  public void setUpdatedAt(Date updatedAt) {
    super.setUpdatedAt(updatedAt);
  }

}
