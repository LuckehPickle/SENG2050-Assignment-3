package uon.seng2050.assignment.model;

import io.seanbailey.adapter.Model;
import java.util.Date;
import java.util.UUID;

public class Article extends Model {

  private UUID id;
  private String title;
  private String body;
  private String answer;
  private int helpfulness;
  private Date publishedAt;
  private Date updatedAt;

  public Article() {
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
      addError("Invalid Article data");
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

  public Date getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(Date publishedAt) {
    this.publishedAt = publishedAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
