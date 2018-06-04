package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import java.util.Date;
import java.util.UUID;

public class Issue extends Model {

  private UUID id;
  private Category category;
  private SubCategory subCategory;
  private State state;
  private String title;
  private String body;
  private Date createdAt;
  private Date updatedAt;
  private Boolean locked;
  //List for comments?

  public Issue() {
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
      addError("Invalid Issue data");
    }
    return false;
  }

  public enum State {
    NEW, INPROGRESS, COMPLETED, RESOLVED
  }

  public enum Category {
    NETWORK, SOFTWARE, HARDWARE, EMAIL, ACCOUNT, OTHER
  }

  public enum SubCategory {
    CANT_CONNECT, SPEED, CONSTANT_DROPOUTS, SLOW_TO_LOAD, WONT_LOAD,
    WONT_BOOT, BLUE_SCREEN, DISK_DRIVE, PERIPHERALS, CANT_SEND,
    CANT_RECEIVE, SPAM, PASSWORD_RESET, WRONG_DETAILS, OTHER
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
