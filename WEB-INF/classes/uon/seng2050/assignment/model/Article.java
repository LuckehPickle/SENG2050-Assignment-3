package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import java.util.Date;
import java.util.UUID;
import uon.seng2050.assignment.model.Issue.Category;
import uon.seng2050.assignment.model.Issue.SubCategory;

public class Article extends Model {

  private UUID id;
  private String title;
  private String body;
  private String answer;
  private int helpfulness;
  private Category category;
  private SubCategory subCategory;

  /**
   * Default constructor. Set any defaults here. Note: All primitives must have a default.
   */
  @SuppressWarnings("unused")
  public Article() {
    helpfulness = 0;
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
  public String getId() {
    return id.toString();
  }

  public void setId(String id) {
    this.id = UUID.fromString(id);
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

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public int getHelpfulness() {
    return helpfulness;
  }

  public void setHelpfulness(int helpfulness) {
    this.helpfulness = helpfulness;
  }

  public String getCategory() {
    return category.name();
  }

  public void setCategory(String category) {
    this.category = Category.valueOf(category);
  }

  public String getSubCategory() {
    return subCategory.name();
  }

  public void setSubCategory(String subCategory) {
    this.subCategory = SubCategory.valueOf(subCategory);
  }
}
