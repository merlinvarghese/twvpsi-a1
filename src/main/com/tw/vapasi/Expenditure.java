package com.tw.vapasi;

import java.util.HashMap;

public class Expenditure {
  private final String spender;
  private final double amount;
  private final String[] beneficiaries;
  private final String expenseType;


  public Expenditure(String spender, double amount, String[] beneficiaries, String expenseType) {
    this.spender = spender;
    this.amount = amount;
    this.beneficiaries = beneficiaries;
    this.expenseType = expenseType;
  }

  public HashMap<String, Double> getApportionedExpense() {
    double avgAmt = 0;
    boolean isSpenderABeneficiary = false;
    HashMap<String, Double> expenses = new HashMap<String, Double>();
    for (String benefissiary : beneficiaries) {
      if (benefissiary.equals(spender))
        isSpenderABeneficiary = true;
    }
    avgAmt = amount / beneficiaries.length;

    if (!isSpenderABeneficiary)
      avgAmt = amount / (beneficiaries.length - 1);

    for (String benefissiary : beneficiaries) {
      if (benefissiary.equals(spender))
        continue;
      expenses.put(benefissiary, avgAmt);
    }
    return expenses;
  }
}
