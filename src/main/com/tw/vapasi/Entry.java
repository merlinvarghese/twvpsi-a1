package com.tw.vapasi;

//Understands each expense/journal entry
public class Entry {

  private String personName;
  private Double amount;

  public Entry(String personName, Double amount) {
    this.personName = personName;
    this.amount = amount;
  }

  public String getPersonName() {
    return personName;
  }

  public Double getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof  Entry))
      return false;
    Entry otherObject = (Entry) obj;
    return personName.equals(otherObject.personName) && amount.equals(otherObject.amount);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder().append("Person : ").append(personName).append(", Amount : ").append(amount).append("\n");
    return stringBuilder.toString();
  }
}
