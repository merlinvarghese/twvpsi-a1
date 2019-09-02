package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExpenditure {
  @Test
  void expectTestMethod() {
    Expenditure expenditure = new Expenditure("A", 400.0, new String[]{"A", "B", "C", "D"}, "Taxi");
    assertEquals(100.0, expenditure.getApportionedExpense().get("B"));
  }

}
