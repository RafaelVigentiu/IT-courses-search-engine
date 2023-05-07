package ex.it_courses.data;

import ex.it_courses.database.Database;
import ex.it_courses.response.ResponseInvalidInterface;
import ex.it_courses.response_exception.ResponseException;

import java.text.MessageFormat;
import java.util.Scanner;

public class GoogleWebsite implements ResponseInvalidInterface {
    public static final String SEARCH = "IT online courses";
    static int correctAnswer = 0;
    static int option = 0;

    void search() {
        System.out.print("Please enter what are you looking for ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (!userInput.equals(SEARCH)) {
            System.out.println("Sorry, I don't understand, please try again.");
            System.out.println("I understand just ->" + SEARCH);
            System.out.println();
            search();
        } else {
            System.out.println();
            System.out.println("You can learn IT online with:");
            Database database = new Database();
            database.getITTrainerList();
        }
    }

    void chooseTheTrainer() { //Problem non-static
        System.out.print("Please choose a trainer: ");
        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();
        GoogleServer googleServer = new GoogleServer();
        checkTheUserResponseForTheTrainer(response, googleServer);
        googleServer.checkUserChoice(response);
        googleServer.getTheCourses(response);
    }

    private void checkTheUserResponseForTheTrainer(int response, GoogleServer googleServer) {
        if (googleServer.checkUserResponseSelectIfValid(response, this)) {
            chooseTheTrainer();
        }
    }

    void afterTheDesiredCourseHasBeenSelected(int response) {
        User user = new User();
        if (checkTheCourseDesiredByTheUser(response)) {
            user.selectTheDesiredCourse();
        } else if (response == 1) {
            javaSelectOption();
            System.out.println();
        } else if (response == 2) {
            option = 2;
            kotlinOrFirebaseOption();
        } else if (response == 3) {
            option = 3;
            kotlinOrFirebaseOption();
        }
    }

    private void javaSelectOption() {
        Database database = new Database();
        User user = new User();
        System.out.println("It is the best choice!");
        System.out.println(MessageFormat.format("You choose {0}", database.getCoursesListFromAlex().get(0)));
        user.askTheUserIfWantToRegister();
    }

    private void kotlinOrFirebaseOption() {
        System.out.print("You have basic knowledge of Java ");
        Scanner scanner = new Scanner(System.in);
        String userResponse = scanner.nextLine();
        GoogleServer googleServer = new GoogleServer();
        User user = new User();
        if (wrongInput(userResponse, googleServer)) {
            kotlinOrFirebaseOption();
        } else if (user.ifNo(userResponse)) {
            userDoesNotHaveJavaBasicKnowledge();
        } else if (user.ifYes(userResponse)) {
            startQuiz();
        }
    }

    public boolean wrongInput(String response, GoogleServer googleServer) {
        return googleServer.checkIfUserResponseIsDifferentThenYesOrNot(response, this);
    }

    private void userDoesNotHaveJavaBasicKnowledge() {
        System.out.println("Sorry, you can't take this course.");
        System.out.println("Because Alex Mamo, is doing the thinks in the right way, we suggest you to take Java course first, before Kotlin - Android.");
        thankYouMessage();
    }

    private void startQuiz() {
        Quiz.totalQuestions++;
        Quiz.evaluationQuestions1();
        checkTheUserInput();
        Quiz.evaluationQuestions2();
        checkTheUserInput();
        Quiz.evaluationQuestions3();
        checkTheUserInput();
        Quiz.finalQuizMessage();
    }

    static void thankYouMessage() {
        System.out.println("Thank you for understanding!");
    }

    private void checkTheQuestionResponse(int userAnswer) {
        switch (userAnswer) {
            case 1 -> {
                System.out.println("Correct answer.");
                correctAnswer++;
            }
            case 2, 3 -> {
                correctAnswer = 0;
                System.out.println("Wrong answer.");
            }
        }
    }

    private void checkTheUserInput() {
        Scanner scanner = new Scanner(System.in);
        GoogleServer googleServer = new GoogleServer();
        int userAnswer;
        do {
            userAnswer = scanner.nextInt();
            googleServer.checkUserResponseSelectIfValid(userAnswer, this);
        } while (userAnswer < 1 || userAnswer > 3);
        checkTheQuestionResponse(userAnswer);
    }


    private boolean checkTheCourseDesiredByTheUser(int response) {
        GoogleServer googleServer = new GoogleServer();
        return googleServer.checkUserResponseSelectIfValid(response, this);
    }

    void afterUserResponseIfWantToRegister(String response, GoogleServer googleServer) {
        User user = new User();
        if (wrongInput(response, googleServer)) {
            user.askTheUserIfWantToRegister();
        }
        if (user.ifNo(response)) {
            goodBye();
        } else if (user.ifYes(response)) {
            Registration googleRegistration = new Registration();
            googleRegistration.registrationForm();
        }
    }

    public String enableUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    void goodBye() {
        System.out.println("Thank you! Good Bye!");
    }

    public User createUser(String name, int age) {
        User user = new User();
        user.setFirstName(name);
        user.setAge(age);
        return user;
    }

    @Override
    public void invalidAnswer(ResponseException exception) {
        System.out.println(exception.getMessage());
    }

}
