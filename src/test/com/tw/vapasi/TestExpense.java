package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestExpense {
  @Test
  void expect100ForAandBandCandDForTaxiWhenAIsSpender() {
    Expense expense = new Expense("A", 400.0, new String[]{"A", "B", "C", "D"}, "Taxi");
    assertEquals(-300.0, expense.apportionedExpense().get("A"));
    assertEquals(100.0, expense.apportionedExpense().get("B"));
    assertEquals(100.0, expense.apportionedExpense().get("C"));
    assertEquals(100.0, expense.apportionedExpense().get("D"));
  }

  @Test
  void expect100ForBandCandDForTaxiWhenAisSpender() {
    Expense expense = new Expense("A", 300.0, new String[]{"B", "C", "D"}, "Taxi");
    assertEquals(100.0, expense.apportionedExpense().get("B"));
    assertEquals(100.0, expense.apportionedExpense().get("C"));
    assertEquals(100.0, expense.apportionedExpense().get("D"));
  }

}
