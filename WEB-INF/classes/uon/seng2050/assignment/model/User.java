package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import java.util.Date;
import java.util.UUID;

public class User extends Model {

  private UUID id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phoneNumber;
  private Role role;
  private Date createdAt;
  private Date updatedAt;

  public User() {
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
      addError("Invalid User data");
    }
    return false;
  }

  public enum Role {
    USER, ITSTAFF
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
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
