package ex.it_courses.database;

import ex.it_courses.data.Course;
import ex.it_courses.data.Name;
import ex.it_courses.data.Trainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
  private static final List<Trainer> trainers = new ArrayList<>();
  static List<Course> courses = new ArrayList<>();
  static List<Course> courses1 = new ArrayList<>();
  static List<Course> courses2 = new ArrayList<>();

  public void addTrainersInDatabase() {
    trainers.add(new Trainer(Name.ALEX_MAMO, "alex.mamo@gmail.com"));
    trainers.add(new Trainer(Name.VlAD_Mihai, "vlad.mihai@gmail.com "));
    trainers.add(new Trainer(Name.George_Rares, "george.rares@gmail.com"));
  }

  public void addCoursesForAlex() {
    courses = Arrays.asList(
      new Course("Java from Scratch", 800, "160h"),
      new Course("Kotlin -> Android development", 1000, "160h"),
      new Course("Firebase -> Cloud", 1500, "280h")
    );
  }

  public void addCoursesForVlad() {
    courses1 = Arrays.asList(
      new Course("C++", 298, "130h"),
      new Course("Python", 500, "100h")
    );
  }

  public void addCoursesForGeorge() {
    courses2 = Arrays.asList(
      new Course("JavaScript", 600, "80h"),
      new Course("Python", 1500, "130h")
    );
  }

  public List<Course> getCoursesListFromAlex() {
    addCoursesForAlex();
    return courses;
  }


  public List<Course> getCoursesListFromVlad() {
    addCoursesForVlad();
    return courses1;
  }


  public List<Course> getCoursesListFromGeorge() {
    addCoursesForGeorge();
    return courses2;
  }

  public void getITTrainerList() {
    addTrainersInDatabase();
    trainers.forEach(System.out::println);
  }
}
