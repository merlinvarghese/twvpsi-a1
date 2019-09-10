package com.tw.vapasi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Understands expense calculations
final class Expense {
  private final String spender;
  private final double amount;
  private final ArrayList<String> beneficiaries;
  private final String expenseType;


  Expense(String spender, double amount, String[] beneficiaries, String expenseType) {
    this.spender = spender;
    this.amount = amount;
    this.beneficiaries = new ArrayList<String>(Arrays.asList(beneficiaries));
    this.expenseType = expenseType;
  }

  List<Entry> apportionedExpense() {
    ArrayList<String> beneficiaryList = new ArrayList<String>(beneficiaries);
    ArrayList<Entry> expenses = new ArrayList<Entry>();
    expenses.add(new Entry(spender, spenderExpense()));
    beneficiaryList.remove(spender);
    for (String beneficiary : beneficiaryList) {
      expenses.add(new Entry(beneficiary, amount / beneficiaries.size()));
    }
    return expenses;
  }

  private Double spenderExpense() {
    double spenderExpense = -1 * amount;
    if (beneficiaries.contains(spender)) {
      spenderExpense = -1 * (amount - amount / beneficiaries.size());
    }
    return spenderExpense;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expense Details : \n")
        .append("Spender : ").append(spender).append("\n")
        .append("Amount : ").append(amount).append("\n")
        .append("Beneficiaries : ").append(beneficiaries).append("\n")
        .append("Expense Type : ").append(expenseType).append("\n");
    return stringBuilder.toString();
  }
}
