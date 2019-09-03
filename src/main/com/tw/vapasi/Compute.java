package com.tw.vapasi;

import java.util.ArrayList;
import java.util.HashMap;

public class Compute {

  private ArrayList<Expense> expenses = new ArrayList<Expense>();

  public void addExpense(Expense expense) {
    expenses.add(expense);
  }

  public HashMap<String, Double> calculateNetExpense(){
    HashMap<String, Double> netExpenses = new HashMap<String, Double>();
    Double personalExpense;
    HashMap<String, Double> apportionedExpense;
    for(Expense expense: expenses) {
      System.out.println("Compute : " + expense);
      apportionedExpense = expense.getApportionedExpense();
      System.out.println("Compute" + apportionedExpense);
      for(String beneficiary : apportionedExpense.keySet()) {
        if (netExpenses.containsKey(beneficiary)) {
          personalExpense = netExpenses.get(beneficiary);
          personalExpense = personalExpense.doubleValue() + apportionedExpense.get(beneficiary).doubleValue();
          netExpenses.put(beneficiary, personalExpense);
          continue;
        }
        netExpenses.put(beneficiary, apportionedExpense.get(beneficiary));
      }
    }
    return netExpenses;
  }


  public static void main(String args[]){
    Compute computeObj =  new Compute();
    Expense expenseForTaxi = new Expense("A", 300.0, new String[]{"B", "C", "D"}, "Taxi");
    Expense expenseForBus = new Expense("A", 400.0, new String[]{"A","B", "C", "D"}, "Bus");
    Expense expenseForFood = new Expense("A", 100.0, new String[]{"A"}, "Bus");
    Expense expenseForCinema = new Expense("B", 200.0, new String[]{"A","B"}, "Bus");
    computeObj.addExpense(expenseForTaxi);
    computeObj.addExpense(expenseForBus);
    computeObj.addExpense(expenseForFood);
    computeObj.addExpense(expenseForCinema);
    System.out.println("Compute net expense");
    System.out.println("Final HM " + computeObj.calculateNetExpense());
    HashMap<String, Double> netExpenses = computeObj.calculateNetExpense();
    System.out.println("*******************************************");
    System.out.println("*******EXPENSE DETAILS FOR THE TRIP********");
    System.out.println("*******************************************");
    for(String person : netExpenses.keySet()) {
      double expense = netExpenses.get(person).doubleValue();
      if(expense < 0.0) {
        System.out.println(person + " gets " + (expense * -1));
      } else {
        System.out.println(person + " gives " + expense);
      }
    }
    System.out.println("*******************************************");
    System.out.println("*******************************************");
  }
}
