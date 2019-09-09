package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCompute {

  @Test
  void expect_AGets300_Bgets100_Cgives200_Dgives200_WhenA_And_B_AreSpenders() {
    Expense taxi = new Expense("A", 300.0, new String[]{"B", "C", "D"}, "Taxi");
    Expense snacks = new Expense("B", 300.0, new String[]{"B", "C", "D"}, "Snacks");

    Compute compute = new Compute();
    compute.addExpense(taxi);
    compute.addExpense(snacks);

    HashMap<String, Double> finalSettlement = compute.calculateNetExpense();
    assertEquals(-300.0, finalSettlement.get("A"));
    assertEquals(-100.0, finalSettlement.get("B"));
    assertEquals(200.0, finalSettlement.get("C"));
    assertEquals(200.0, finalSettlement.get("D"));
  }

  @Test
  void expect_AGives75_BGets325_CGives275_DGets25WhenA_B_D_AreSpenders() {
    Expense snacks = new Expense("A", 100.0, new String[]{"A", "B", "C", "D"}, "Snacks");
    Expense taxi = new Expense("B", 500.0, new String[]{"C", "D"}, "Taxi");
    Expense bus = new Expense("D", 300.0, new String[]{"A", "B"}, "Bus");

    Compute compute = new Compute();
    compute.addExpense(snacks);
    compute.addExpense(taxi);
    compute.addExpense(bus);
    HashMap<String, Double> finalSettlement = compute.calculateNetExpense();
    assertEquals(75.0, finalSettlement.get("A"));
    assertEquals(-325.0, finalSettlement.get("B"));
    assertEquals(275.0, finalSettlement.get("C"));
    assertEquals(-25.0, finalSettlement.get("D"));
  }

  @Test
  void expect_AGets300_BGivess100_CGives100_DGives100WhenAIsSpender() {
    Expense taxi = new Expense("A", 300.0, new String[]{"B", "C", "D"}, "Taxi");

    Compute compute = new Compute();
    compute.addExpense(taxi);
    HashMap<String, Double> finalSettlement = compute.calculateNetExpense();
    assertEquals(-300.0, finalSettlement.get("A"));
    assertEquals(100.0, finalSettlement.get("B"));
    assertEquals(100.0, finalSettlement.get("C"));
    assertEquals(100.0, finalSettlement.get("D"));
  }

  @Test
  void expectFinalSettlement_Zero_WhenOnlyAIsSpenderAndBeneficiary() {
    Expense food = new Expense("A", 300.0, new String[]{"A"}, "Food");

    Compute compute = new Compute();
    compute.addExpense(food);
    HashMap<String, Double> finalSettlement = compute.calculateNetExpense();
    assertEquals(-0.0, finalSettlement.get("A"));
  }
}
