package ex.it_courses.data;

import ex.it_courses.calback.OnRegistrationCallback;
import ex.it_courses.database.Database;
import ex.it_courses.response.Messages;
import ex.it_courses.response.ResponseInvalidInterface;
import ex.it_courses.response_exception.ResponseException;

import java.util.function.Predicate;

public class GoogleServer {
 Database database = new Database();

  public boolean checkUserResponseSelectIfValid(int userResponse, ResponseInvalidInterface response) {
//      Predicate<Integer> verify = response -> response == 1 || response == 2;

      if (userResponse < 1 || userResponse > 3) {
      response.invalidAnswer(new ResponseException("Invalid response, please answer with 1 -> 2 -> 3!"));
      return true;
    }
    return false;
  }

  public boolean checkIfUserResponseIsDifferentThenYesOrNot(String userResponse, ResponseInvalidInterface response) {
    if (!(userResponse.equals("y") || userResponse.equals("n"))) {
      response.invalidAnswer(new ResponseException("Please answer with y -> or -> n"));
      return true;
    }
    return false;
  }

  public boolean isValidUserCnp(String cnp, ResponseInvalidInterface response) {
    boolean check = false;
    if (cnp.length() != 13) {
      response.invalidAnswer(new ResponseException(Messages.INVALID_CNP));
      check = true;
    } else if (cnp.matches(".*[a-zA-Z]")) {
      System.out.println("Only numbers!");
      check = true;
    }
    return check;
  }

  public boolean isValidUserEmail(String email, ex.it_courses.response.ResponseInvalidInterface exception) {
    if (!email.contains("@") || !email.contains(".") || email.length() < 20) {
      exception.invalidAnswer(new ResponseException("The email must be contain @ and and the length cannot be less than 20."));
      return true;
    }
    return false;
  }

  public boolean isValidUserName(String name, ex.it_courses.response.ResponseInvalidInterface exception) {
    boolean check = false;
    if (containNumber(name)) {
      System.out.println("The name cannot contain numbers. Please enter a valid name!");
      check = true;
    } else if (name.length() < 3) {
      System.out.println("The first name is to small.");
      check = true;
    }
    return check;
  }

  public boolean containNumber(String name) {
    char c;
    boolean check = false;
    for (int i = 0; i < name.length(); i++) {
      c = name.charAt(i);
      if (Character.isDigit(c)) {
        return true;
      }
    }
    return check;
  }

  public void finallyResponse(OnRegistrationCallback response) {
    System.out.println();
    response.onSuccess(Messages.SUCCESSFULLY_REGISTRATION);
    response.onSuccess(Messages.CALL_FROM_TRAINER);
  }

  public void checkUserChoice(int userChoice) {
    switch (userChoice) {
      case 1 -> {
        System.out.println();
        System.out.println("You chose Alex Mamo as your trainer. One of the best trainer. You're lucky!");
      }
      case 2 -> {
        System.out.println();
        System.out.println("You chose Vlad Mihai as your trainer, but Alex Mamo is the best! :)");
      }
      case 3 -> {
        System.out.println();
        System.out.println("You chose George Rares as your trainer, but Alex Mamo is the best! :)");
      }
    }
  }

  public void getTheCourses(int userChoice) {
    User user = new User();
    switch (userChoice) {
      case 1 -> {
        this.database.getCoursesListFromAlex();
        database.getCoursesListFromAlex().forEach(System.out::println);
        user.selectTheDesiredCourse();

      }
      case 2 -> {
        this.database.getCoursesListFromVlad();
        this.database.getCoursesListFromVlad().forEach(System.out::println);
      }
      case 3 -> {
        this.database.getCoursesListFromGeorge();
        this.database.getCoursesListFromGeorge().forEach(System.out::println);
      }
    }
  }
}
