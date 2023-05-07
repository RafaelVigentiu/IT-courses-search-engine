package ex.it_courses.calback;

@FunctionalInterface
public interface OnRegistrationCallback {
  void onSuccess(String message);
}
