package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import io.seanbailey.adapter.exception.SQLAdapterException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public class Comment extends Model {

  private UUID id;
  private UUID issueId;
  private UUID authorId;
  private String body;
  private boolean edited;


  /**
   * Default constructor. Set any defaults here. Note: All primitives must have a default.
   */
  @SuppressWarnings("unused")
  public Comment() {
    edited = false;
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

    // Validate body
    if (body == null) {
      addError("Comment body must be present.");
      valid = false;
    } else if (body.length() > 500) {
      addError("Comment body must be less than 500 characters long.");
      valid = false;
    }

    return valid;

  }


  //GET/SET
  public User getAuthor() {

    List<Model> authors = null;

    try {
      authors = Model.find(User.class, "id", authorId.toString()).execute();
    } catch (SQLException | SQLAdapterException e) {
      e.printStackTrace();
    }

    if (authors.isEmpty()) {
      return null;
    }

    return (User) authors.get(0);

  }

  public String getId() {
    return id.toString();
  }

  public void setId(String id) {
    this.id = UUID.fromString(id);
  }

  public String getIssueId() {
    return issueId.toString();
  }

  public void setIssueId(String issueId) {
    this.issueId = UUID.fromString(issueId);
  }

  public String getAuthorId() {
    return authorId.toString();
  }

  public void setAuthorId(String authorId) {
    this.authorId = UUID.fromString(authorId);
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public boolean isEdited() {
    return edited;
  }

  public void setEdited(boolean edited) {
    this.edited = edited;
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
