package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

//Understands how to get journal of expenses and compute balances
class FinalSettlement {

  private ArrayList<Expense> expenseList = new ArrayList<>();

  void addExpense(Expense expense) {
    expenseList.add(expense);
  }

  void addMultipleExpenses(List<Expense> expenses) {
    expenseList.addAll(expenses);
  }

  private Journal getJournal() {
    Journal journal = new Journal();
    for (Expense expense : expenseList) {
      journal.addMultipleEntries(expense.apportionedExpense());
    }
    return journal;
  }

  public void computeBalances() {
    Journal journal = getJournal();
    for (String person : journal.getParticipants()) {
      double expense = journal.getPersonalExpense(person);
      if (expense < 0.0) {
        System.out.println(person + " gets " + (expense * -1));
      } else {
        System.out.println(person + " gives " + expense);
      }
    }
  }

  public void readConsoleInput() {
    addMultipleExpenses(new ConsoleReader().readExpensesFromConsole());
  }

  public static void main(String args[]) {
    //System.out.println(new ConsoleReader().readExpensesFromConsole());

    FinalSettlement finalSettlementObj = new FinalSettlement();

    finalSettlementObj.addExpense(new Expense("A", 100.0, new String[]{"A", "B", "C", "D"}, "Snacks"));
    finalSettlementObj.addExpense(new Expense("B", 500.0, new String[]{"C", "D"}, "Taxi"));
    finalSettlementObj.addExpense(new Expense("D", 300.0, new String[]{"A", "B"}, "Bus"));
    finalSettlementObj.computeBalances();


  }
}