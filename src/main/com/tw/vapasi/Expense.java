package com.tw.vapasi;

import java.util.HashMap;

//Understands expense calculations
class Expense {
  private final String spender;
  private final double amount;
  private final String[] beneficiaries;
  private final String expenseType;


  public Expense(String spender, double amount, String[] beneficiaries, String expenseType) {
    this.spender = spender;
    this.amount = amount;
    this.beneficiaries = beneficiaries;
    this.expenseType = expenseType;
  }

  public String getSpender() {
    return spender;
  }

  public String[] getBeneficiaries() {
    return beneficiaries;
  }

  public HashMap<String, Double> getApportionedExpense() {
    double avgAmt = amount / beneficiaries.length;
    boolean isSpenderABeneficiary = false;
    HashMap<String, Double> expenses = new HashMap<String, Double>();

    for (String beneficiary : beneficiaries) {
      if (beneficiary.equals(spender)) {
        isSpenderABeneficiary = true;
      }
    }
    if (isSpenderABeneficiary) {
      System.out.println("Spender is a beneficiary");
      expenses.put(spender, -1 * (amount - avgAmt));
    }
    if (!isSpenderABeneficiary) {
      System.out.println("Spender is not a beneficiary");
      expenses.put(spender, -1 * amount);
    }
    System.out.println(expenses);

    for (String beneficiary : beneficiaries) {
      if (beneficiary.equals(spender)) {
        continue;
      }
      expenses.put(beneficiary, avgAmt);
    }
    System.out.println(expenses);
    return expenses;
  }
}
