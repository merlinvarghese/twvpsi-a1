package com.tw.vapasi;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompute {

  @Test
  void expect100ForBandCandDForTaxiWhenAisSpender1() {
    Expense taxi = new Expense("A", 300.0, new String[]{"B", "C", "D"}, "Taxi");
    Expense snacks = new Expense("B", 300.0, new String[]{"B", "C", "D"}, "Snacks");
    Compute compute = new Compute();
    compute.addExpense(taxi);
    compute.addExpense(snacks);
    HashMap<String, Double> finalExpense = compute.calculateNetExpense();
    assertEquals(-300.0, finalExpense.get("A"));
    assertEquals(-100.0, finalExpense.get("B"));
    assertEquals(200.0, finalExpense.get("C"));
    assertEquals(200.0, finalExpense.get("D"));
  }

  @Test
  void expectSampleTestCaseProvided() {
    Expense expense1 = new Expense("A", 100.0, new String[]{"A", "B", "C", "D"}, "Snacks");
    Expense expense2 = new Expense("B", 500.0, new String[]{"C", "D"}, "Taxi");
    Expense expense3 = new Expense("D", 300.0, new String[]{"A", "B"}, "Bus");
    Compute compute = new Compute();
    compute.addExpense(expense1);
    compute.addExpense(expense2);
    compute.addExpense(expense3);
    HashMap<String, Double> expense = compute.calculateNetExpense();
    assertEquals(75.0, expense.get("A"));
    assertEquals(-325.0, expense.get("B"));
    assertEquals(275.0, expense.get("C"));
    assertEquals(-25.0, expense.get("D"));
  }

  @Test
  void expect100ForBandCandDForTaxiWhenAisSpenderUsingCompute() {
    Expense expense1 = new Expense("A", 300.0, new String[]{"B", "C", "D"}, "Taxi");
    Compute compute = new Compute();
    compute.addExpense(expense1);
    HashMap<String, Double> expense = compute.calculateNetExpense();
    assertEquals(-300.0, expense.get("A"));
    assertEquals(100.0, expense.get("B"));
    assertEquals(100.0, expense.get("C"));
    assertEquals(100.0, expense.get("D"));
  }

  @Test
  void expect0ForAForTaxiWhenAisSpenderUsingCompute() {
    Expense expense1 = new Expense("A", 300.0, new String[]{"A"}, "Taxi");
    Compute compute = new Compute();
    compute.addExpense(expense1);
    HashMap<String, Double> expense = compute.calculateNetExpense();
    assertEquals(-0.0, expense.get("A"));
  }
}
