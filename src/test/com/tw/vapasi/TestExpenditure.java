package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExpenditure {
  @Test
  void expect100ForAandBandCandDForTaxiWhenAIsSpender() {
    Expenditure expenditure = new Expenditure("A", 400.0, new String[]{"A", "B", "C", "D"}, "Taxi");
    assertEquals(100.0, expenditure.getApportionedExpense().get("A"));
    assertEquals(100.0, expenditure.getApportionedExpense().get("B"));
    assertEquals(100.0, expenditure.getApportionedExpense().get("C"));
    assertEquals(100.0, expenditure.getApportionedExpense().get("D"));
  }

  @Test
  void expect100ForBandCandDForTaxiWhenAIsSpender() {
    Expenditure expenditure = new Expenditure("A", 300.0, new String[]{"B", "C", "D"}, "Taxi");
    assertEquals(100.0, expenditure.getApportionedExpense().get("B"));
    assertEquals(100.0, expenditure.getApportionedExpense().get("C"));
    assertEquals(100.0, expenditure.getApportionedExpense().get("D"));
  }
}
