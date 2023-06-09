package ex.it_courses.data;

public class Credential {

  private String name;
  private int age;
  private String email;
  private String phoneNumber;
  private String cnp;


  public Credential(String name, String cnp, String email, String phoneNumber) {
    this.name = name;
    this.cnp = cnp;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public String getCnp() {
    return cnp;
  }

  public void setCnp(String cnp) {
    this.cnp = cnp;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  @Override
  public String toString() {
    return String.format("Name -> %s\nCnp -> %s\nEmail -> %s\nPhone -> %s",
      this.name, this.cnp, this.email, this.phoneNumber);
  }
}
