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


  /**
   * Default constructor. Set any defaults here. Note: All primitives must have a default.
   */
  public User() {
  }


  /**
   * AN enum which represents the current role of this user.
   *
   * @see java.lang.Enum
   */
  @SuppressWarnings("unused")
  public enum Role {
    USER, IT_STAFF
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
    return true;
  }


  public String getFullName() {
    return firstName + " " + lastName;
  }


  public String getId() {
    return id.toString();
  }

  public void setId(String id) {
    this.id = UUID.fromString(id);
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

  public String getRole() {
    return role.name();
  }

  public void setRole(String role) {
    this.role = Role.valueOf(role);
  }

}
