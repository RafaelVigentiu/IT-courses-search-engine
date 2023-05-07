package ex.it_courses.data;

import java.util.Date;

public class Contract {

  private Credential credential;
  private Date date;

  public Contract(Credential credential) {
    this.credential = credential;
    this.date = new Date();
  }


  public void getContract(Contract contract) {
    System.out.println(contract);
  }

  public Credential getCredential() {
    return credential;
  }

  public void setCredential(Credential credential) {
    this.credential = credential;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    System.out.println();
    return String.format("Your Contract -> Credentials\n%s", this.credential);
  }
}
