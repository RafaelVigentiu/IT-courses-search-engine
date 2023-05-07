package ex.it_courses.data;

import java.util.Scanner;

public class User {
  private String firstName;
  private String lastName;
  private int age;
  private String phoneNumber;
  private String Email;
  private String country;
  private String city;


  public User() {
  }

  public User(String name, int age) {
    this.firstName = name;
    this.age = age;
  }


  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return Email;
  }

  public String getCountry() {
    return country;
  }

  public String getCity() {
    return city;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void openGoogleWebsite() {
    GoogleWebsite googleWebsite = new GoogleWebsite();
    googleWebsite.search();
    googleWebsite.chooseTheTrainer();
  }


  public void askTheUserIfWantToRegister() {
    GoogleWebsite googleWebsite = new GoogleWebsite();
    GoogleServer googleServer = new GoogleServer();
    System.out.println();
    System.out.print("Do you want to register? ");
    Scanner scanner = new Scanner(System.in);
    String response = scanner.nextLine();
    googleWebsite.afterUserResponseIfWantToRegister(response, googleServer);
  }


  public void selectTheDesiredCourse() {
    GoogleWebsite googleWebsite = new GoogleWebsite();
    System.out.println();
    System.out.print("Please choose the desired course! ");
    Scanner scanner = new Scanner(System.in);
    int userResponse = scanner.nextInt();
    googleWebsite.afterTheDesiredCourseHasBeenSelected(userResponse);
  }

  public String enterUserEmail() {
    GoogleWebsite googleWebsite = new GoogleWebsite();
    GoogleServer googleServer = new GoogleServer();
    Registration googleRegistration = new Registration();
    System.out.print("Please enter your email ");
    String email = googleWebsite.enableUserInput();
    googleRegistration.wrongUserInputEmail(email, googleServer);
    return email;
  }

  public String enterUserCnp() {
    GoogleWebsite googleWebsite = new GoogleWebsite();
    GoogleServer googleServer = new GoogleServer();
    Registration registration = new Registration();
    System.out.print("Please enter your CNP ");
    String cnp = googleWebsite.enableUserInput();
    registration.wrongUserInputCnp(cnp, googleServer);
    return cnp;
  }

  public String enterUserName() {
    GoogleWebsite googleWebsite = new GoogleWebsite();
    GoogleServer googleServer = new GoogleServer();
    Registration googleRegistration = new Registration();
    System.out.print("Please enter your name! ");
    String name = googleWebsite.enableUserInput();
    googleRegistration.wrongUserInputName(name, googleServer);
    return name;
  }

  public boolean ifNo(String response) {
    return "n".equals(response);
  }

  public boolean ifYes(String response) {
    return "y".equals(response);
  }
}
