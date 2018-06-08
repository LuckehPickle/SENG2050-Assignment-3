package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import java.util.Date;
import java.util.UUID;

public class MaintenanceEvent extends Model {

  private UUID id;
  private String title;
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
    boolean valid = true;
    if(id == null) {
      addError("ID is null");
      valid = false;
    }
    if(title == null) {
      addError("Title is null");
      valid = false;
    }
    if(startAt == null) {
      addError("startAt is null");
      valid = false;
    }
    if(finishAt == null) {
      addError("finishAt is null");
      valid = false;
    }
    if(valid) {
      if(startAt.compareTo(finishAt) > 0) {
        addError("The end date cannot be earlier than the start date.");
        valid = false;
      }
      if(title.isEmpty()) {
        addError("Please enter a name for the event");
        valid = false;
      }
    }

    return valid;
  }


  //GET/SET
  public String getId() {
    return id.toString();
  }

  public void setId(String id) {
    this.id = UUID.fromString(id);
  }

  public void generateID(){ this.id = UUID.randomUUID();}

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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
