package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import java.util.Date;
import java.util.UUID;

public class Comment extends Model {

  private UUID id;
  private String body;
  private boolean edited;
  private Date createdAt;
  private Date updatedAt;

  public Comment() {
    //constructor
  }

  @Override
  public boolean validate() {
    boolean isValid = true;
    //run data checks
    if(isValid) {
      return true;
    }
    else {
      addError("Invalid Comment data");
    }
    return false;
  }

  //GET/SET
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
