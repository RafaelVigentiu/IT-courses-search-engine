package ex.it_courses.data;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
  private Name name;
  private String email;
  static List<Contract> contracts = new ArrayList<>();

  public Trainer(Name name, String email) {
    this.name = name;
    this.email = email;
  }

  public Trainer() {
  }

  public Name getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Contract> getContracts() {
    return contracts;
  }

  public static void setContracts(List<Contract> contracts) {
    Trainer.contracts = contracts;
  }


  public static void addContract(Contract contract) {
    contracts.add(contract);
  }

  @Override
  public String toString() {
    return String.format("Trainer name: %s\nEmmail: %s\n ", name, email);
  }


}
