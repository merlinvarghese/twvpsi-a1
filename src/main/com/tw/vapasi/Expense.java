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

  public HashMap<String, Double> getApportionedExpense() {
    double avgAmt = amount / beneficiaries.length;
    boolean isSpenderABeneficiary = false;
    HashMap<String, Double> expenses = new HashMap<String, Double>();

    for (String beneficiary : beneficiaries) {
      if (beneficiary.equals(spender)) {
        isSpenderABeneficiary = true;
      }
    }

    for (String beneficiary : beneficiaries) {
      if (beneficiary.equals(spender) && !isSpenderABeneficiary)
        continue;
      expenses.put(beneficiary, avgAmt);
    }
    return expenses;
  }
}
