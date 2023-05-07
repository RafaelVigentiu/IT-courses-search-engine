package ex.it_courses.data;

import ex.it_courses.calback.OnRegistrationCallback;
import ex.it_courses.response.ResponseInvalidInterface;
import ex.it_courses.response_exception.ResponseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registration implements ex.it_courses.response.ResponseInvalidInterface, ex.it_courses.calback.OnRegistrationCallback {
  static List<Credential> credentials = new ArrayList<>();
  Credential credential;


  void registrationForm() {
    GoogleWebsite googleWebsite = new GoogleWebsite();
    User user = new User();
    Scanner scanner = new Scanner(System.in);
    String name = user.enterUserName();
    String cnp = user.enterUserCnp();
    String email = user.enterUserEmail();

    System.out.print("Please enter your phone number ");
    String phoneNumber = googleWebsite.enableUserInput();

    if (ultimateQuestionBeforeRegister()) {
      addCredentialIfUserRegister(name, cnp, email, phoneNumber);
      Contract contract = new Contract(credential);
      contract.getContract(contract);
      Trainer.addContract(contract);
    }
  }

  private void addCredentialIfUserRegister(String name, String cnp, String email, String phoneNumber) {
    credential = new Credential(name, cnp, email, phoneNumber);
  }

  private boolean ultimateQuestionBeforeRegister() {
    Scanner scanner = new Scanner(System.in);
    GoogleServer googleServer = new GoogleServer();
    GoogleWebsite googleWebsite = new GoogleWebsite();
    User user = new User();
    boolean check = false;

    System.out.print("You are sure you want to register? ");
    String response = scanner.nextLine();
    if (googleWebsite.wrongInput(response, googleServer)) {
      ultimateQuestionBeforeRegister();
    } else if (user.ifYes(response)) {
      responseAfterUserRegister(googleServer);
      check = true;
    } else if (user.ifNo(response)) {
      googleWebsite.goodBye();
    }
    return check;
  }

  private void responseAfterUserRegister(GoogleServer googleServer) {
    googleServer.finallyResponse(this);
  }

  void wrongUserInputEmail(String email, GoogleServer googleServer) {
    User user = new User();
    if (googleServer.isValidUserEmail(email, this)) {
      user.enterUserEmail();
    }
  }


  void wrongUserInputName(String name, GoogleServer googleServer) {
    User user = new User();
    if (googleServer.isValidUserName(name, this)) {
      user.enterUserName();
    }
  }

  void wrongUserInputCnp(String cnp, GoogleServer googleServer) {
    User user = new User();
    if (googleServer.isValidUserCnp(cnp, this)) {
      user.enterUserCnp();
    }
  }

  @Override
  public void invalidAnswer(ResponseException exception) {
    System.out.println(exception.getMessage());
  }

  @Override
  public void onSuccess(String message) {
    System.out.println(message);
  }

  @Override
  public String toString() {
    return "Registration{" +
      "credential=" + credential +
      '}';
  }
}
