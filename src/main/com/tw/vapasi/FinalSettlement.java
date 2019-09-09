package com.tw.vapasi;

import java.util.ArrayList;
import java.util.HashMap;

//Understands expense computations
class FinalSettlement {

  private ArrayList<Expense> expenseList = new ArrayList<>();

  void addExpense(Expense expense) {
    expenseList.add(expense);
  }

  HashMap<String, Double> calculateNetExpense() {
    HashMap<String, Double> netExpenses = new HashMap<String, Double>();
    HashMap<String, Double> eachApportionedExpense;
    for (Expense expense : expenseList) {
      System.out.println("Compute : " + expense);
      eachApportionedExpense = expense.apportionedExpense();
      System.out.println("Compute" + eachApportionedExpense);
      addApportionedExpenses(netExpenses,eachApportionedExpense);
    }
    return netExpenses;
  }

  private void addApportionedExpenses(HashMap<String, Double> netExpenses, HashMap<String, Double> apportionedExpense) {
    for (String beneficiary : apportionedExpense.keySet()) {
      if (netExpenses.containsKey(beneficiary)) {
        netExpenses.put(beneficiary, netExpenses.get(beneficiary).doubleValue() + apportionedExpense.get(beneficiary).doubleValue());
        continue;
      }
      netExpenses.put(beneficiary, apportionedExpense.get(beneficiary));
    }
  }

  public static void main(String args[]) {
    System.out.println(new ConsoleReader().readExpensesFromConsole());
    /*
    FinalSettlement finalSettlementObj = new FinalSettlement();

    finalSettlementObj.addExpense(new Expense("A", 100.0, new String[]{"A", "B", "C", "D"}, "Snacks"));
    finalSettlementObj.addExpense(new Expense("B", 500.0, new String[]{"C", "D"}, "Taxi"));
    finalSettlementObj.addExpense(new Expense("D", 300.0, new String[]{"A", "B"}, "Bus"));

    System.out.println("Compute net expense");
    System.out.println("Final HM " + finalSettlementObj.calculateNetExpense());
    HashMap<String, Double> netExpenses = finalSettlementObj.calculateNetExpense();


    for (String person : netExpenses.keySet()) {
      double expense = netExpenses.get(person).doubleValue();
      if (expense < 0.0) {
        System.out.println(person + " gets " + (expense * -1));
      } else {
        System.out.println(person + " gives " + expense);
      }
    }*/
  }
}