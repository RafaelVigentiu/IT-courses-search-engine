package ex.it_courses.response;

import ex.it_courses.response_exception.ResponseException;

@FunctionalInterface
public interface ResponseInvalidInterface {
//  void validAnswer(String message);
  void invalidAnswer(ResponseException exception);
}
