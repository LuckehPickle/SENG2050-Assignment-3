package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import io.seanbailey.adapter.annotation.PrimaryKey;
import java.util.Date;
import java.util.UUID;

/**
 *
 */
public class Comment extends Model {

  @PrimaryKey
  private UUID id;
  private UUID issueId;
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
    return false;
  }


  //GET/SET
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getIssueId() {
    return issueId;
  }

  public void setIssueId(UUID issueId) {
    this.issueId = issueId;
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

}
