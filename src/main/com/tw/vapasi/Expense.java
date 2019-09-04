package com.tw.vapasi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Understands expense calculations
class Expense {
  private final String spender;
  private final double amount;
  private final ArrayList<String> beneficiaries;
  private final String expenseType;


  public Expense(String spender, double amount, String[] beneficiaries, String expenseType) {
    this.spender = spender;
    this.amount = amount;
    this.beneficiaries = new ArrayList<String>(Arrays.asList(beneficiaries));
    this.expenseType = expenseType;
  }
/*
  public String getSpender() {
    return spender;
  }

  public ArrayList<String> getBeneficiaries() {
    return beneficiaries;
  }
*/
  public HashMap<String, Double> getApportionedExpense() {
    ArrayList<String> beneficiaryList = new ArrayList<String>(beneficiaries);
    HashMap<String, Double> expenses = new HashMap<String, Double>();
    expenses.put(spender, getSpenderExpenses());
    beneficiaryList.remove(spender);
    for (String beneficiary : beneficiaryList) {
      expenses.put(beneficiary, amount / beneficiaries.size());
    }
    return expenses;
  }

  private Double getSpenderExpenses() {
    double spenderExpense =  -1 * amount;
    if(beneficiaries.contains(spender)) {
      spenderExpense = -1 * (amount - amount/beneficiaries.size());
    }
    return spenderExpense;
  }
}
