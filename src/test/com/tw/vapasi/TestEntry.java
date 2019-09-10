package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestEntry {
  @Test
  void expect100ForAandBandCandDForTaxiWhenAIsSpenderAndBeneficiary() {
    Expense expense = new Expense("A", 400.0, new String[]{"A", "B", "C", "D"}, "Taxi");
    assertTrue(expense.apportionedExpense().contains(new Entry("A", -300.0)));
    assertTrue(expense.apportionedExpense().contains(new Entry("B", 100.0)));
    assertTrue(expense.apportionedExpense().contains(new Entry("C", 100.0)));
    assertTrue(expense.apportionedExpense().contains(new Entry("D", 100.0)));
  }

  @Test
  void expect100ForBandCandDForTaxiWhenAisOnlySpender() {
    Expense expense = new Expense("A", 300.0, new String[]{"B", "C", "D"}, "Taxi");
    assertTrue(expense.apportionedExpense().contains(new Entry("B", 100.0)));
    assertTrue(expense.apportionedExpense().contains(new Entry("C", 100.0)));
    assertTrue(expense.apportionedExpense().contains(new Entry("D", 100.0)));
  }

  @Test
  void expect0ForAForTaxiWhenAisSpenderAndTheOnlyBeneficiary() {
    Expense expense = new Expense("A", 300.0, new String[]{"A"}, "Taxi");
    assertTrue(expense.apportionedExpense().contains(new Entry("A", -0.0)));
  }
}
