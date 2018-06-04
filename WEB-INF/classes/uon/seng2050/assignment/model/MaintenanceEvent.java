package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import java.util.Date;
import java.util.UUID;

public class MaintenanceEvent extends Model {

  private UUID id;
  private String description;
  private Date startAt;
  private Date finishAt;
  private Date createdAt;
  private Date updatedAt;

  public MaintenanceEvent() {
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
      addError("Invalid MaintenanceEvent data");
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
