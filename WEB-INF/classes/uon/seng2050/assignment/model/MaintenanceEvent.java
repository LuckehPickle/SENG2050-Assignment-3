package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import java.util.Date;
import java.util.UUID;

public class MaintenanceEvent extends Model {

  private UUID id;
  private String description;
  private Date startAt;
  private Date finishAt;


  /**
   * Default constructor. Set any defaults here. Note: All primitives must have a default.
   */
  @SuppressWarnings("unused")
  public MaintenanceEvent() { }


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
  public String getId() {
    return id.toString();
  }

  public void setId(String id) {
    this.id = UUID.fromString(id);
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartAt() {
    return startAt;
  }

  public void setStartAt(Date startAt) {
    this.startAt = startAt;
  }

  public Date getFinishAt() {
    return finishAt;
  }

  public void setFinishAt(Date finishAt) {
    this.finishAt = finishAt;
  }

}
