package ex.it_courses.data;

import ex.it_courses.response.Messages;

public class Quiz {
  static int totalQuestions = 0;

  public static void evaluationQuestions1() {
    System.out.println();
    System.out.println("Evaluation questions!");
    System.out.println("If a class inherits from another class which keyword is used?");
    System.out.println("1. extends");
    System.out.println("1. implements");
    System.out.println("3. inherit");
    System.out.print("Please choose the correct answer! ");
  }

  public static void evaluationQuestions2() {
    System.out.println();
    System.out.println("How to stop the inheritance mechanism, if don't want other classes to inherit from a class?");
    System.out.println("Which keyword is used?");
    System.out.println("1. final");
    System.out.println("2. static");
    System.out.println("3. static-final");
    System.out.print("Please choose the correct answer! ");
  }

  public static void evaluationQuestions3() {
    System.out.println();
    System.out.println("How many class you can extend in Java?");
    System.out.println("1. One");
    System.out.println("2. I can't extent another class");
    System.out.println("3. How many I want");
    System.out.print("Please choose the correct answer! ");
  }

  public static void checkResultQuiz(int number) {
    if (number == 3) {
      System.out.println("Thank you! You can take the Kotlin -> Android -> Development course.");
      User user = new User();
      user.askTheUserIfWantToRegister();
    }
    if (number == 2 || number == 1 || number == 0) {
      System.out.println();
      System.out.println(Messages.DID_NOT_PASS_QUIZ);
      System.out.println(Messages.CANT_TAKE_THE_KOTLIN_COURSE);
      System.out.println(Messages.TAKE_THE_JAVA_COURSE_FIRST);
      GoogleWebsite.thankYouMessage();
    }
  }

  public static void checkResultQuiz1(int number) {
    if (number == 3) {
      System.out.println("Thank you! You can take the Firebase -> Cloud course");
      User user = new User();
      user.askTheUserIfWantToRegister();
    }
    if (number == 2 || number == 1 || number == 0) {
      System.out.println();
      System.out.println(Messages.DID_NOT_PASS_QUIZ);
      System.out.println(Messages.CANT_TAKE_THE_FIREBASE_COURSE);
      System.out.println(Messages.TAKE_THE_JAVA_COURSE_FIRST);
      GoogleWebsite.thankYouMessage();
    }
  }


  public static void finalQuizMessage() {
    if (GoogleWebsite.option == 2) {
      checkResultQuiz(GoogleWebsite.correctAnswer);
    } else if (GoogleWebsite.option == 3)
      checkResultQuiz1(GoogleWebsite.correctAnswer);
  }
}
