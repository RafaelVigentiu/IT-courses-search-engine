package ex.it_courses.data;

import java.util.Date;

public class Course {
  private String courseName;
  private double price;
  private String details;
  private Date date;

  public Course(String courseName, double price, String details) {
    this.courseName = courseName;
    this.price = price;
    this.details = details;
  }

  public String getCourseName() {
    return courseName;
  }


  public double getPrice() {
    return price;
  }


  public String getDetails() {
    return details;
  }


  public Date getDate() {
    return date;
  }

  @Override
  public String toString() {
    return String.format("Course -> %s, Price -> %s$, Details -> %s", this.courseName, this.price, this.details);
  }
}
