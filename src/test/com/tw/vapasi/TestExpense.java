package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExpense {
  @Test
  void expect100ForAandBandCandDForTaxiWhenAisSpender() {
    Expense expense = new Expense("A", 400.0, new String[]{"A", "B", "C", "D"}, "Taxi");
    assertEquals(0.0, expense.getApportionedExpense().get("A"));
    assertEquals(100.0, expense.getApportionedExpense().get("B"));
    assertEquals(100.0, expense.getApportionedExpense().get("C"));
    assertEquals(100.0, expense.getApportionedExpense().get("D"));
  }

  @Test
  void expect100ForBandCandDForTaxiWhenAisSpender() {
    Expense expense = new Expense("A", 300.0, new String[]{"B", "C", "D"}, "Taxi");
    assertEquals(100.0, expense.getApportionedExpense().get("B"));
    assertEquals(100.0, expense.getApportionedExpense().get("C"));
    assertEquals(100.0, expense.getApportionedExpense().get("D"));
  }

}
