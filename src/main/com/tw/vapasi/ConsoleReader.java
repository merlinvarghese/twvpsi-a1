package com.tw.vapasi;

import java.util.*;

public class ConsoleReader {

  public List<Expense> readExpensesFromConsole() {
    List<Expense> expenses = new ArrayList<Expense>();
    printIntroduction();
    while(hasMoreExpensesToAdd()) {
      expenses.add(readExpense());
    }
    return expenses;
  }

  private void printIntroduction() {
    System.out.println("***************************************");
    System.out.println("*******Welcome to Expense Manager******");
    System.out.println("***************************************");
  }

  private Expense readExpense() {
    String spender;
    Double amount;
    String beneficiaries;
    String expenseType;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter the name of Spender");
    spender = scanner.next();
    System.out.println("Please enter the amount spent");
    amount = Double.parseDouble(scanner.next());
    System.out.println("Please enter the names of beneficiaries separated by , (eg. A,B)");
    beneficiaries = scanner.next();;
    System.out.println("Please enter the expense type");
    expenseType = scanner.next();
    return new Expense(spender, amount, parseBeneficiaries(beneficiaries), expenseType);
  }

  private String[] parseBeneficiaries(String beneficiaries) {
    System.out.println("Beneficiary String : " + beneficiaries);
    beneficiaries = beneficiaries.trim().replaceAll(",$", "");
    System.out.println("Beneficiary String after regex: " + beneficiaries);
    StringTokenizer tokenizer = new StringTokenizer(beneficiaries,",");
    String[] parsedBeneficiaryTokens = new String[tokenizer.countTokens()];
    System.out.println("Token count : " + parsedBeneficiaryTokens.length);
    for(int i = 0; i < tokenizer.countTokens(); i++) {
      parsedBeneficiaryTokens[i] = tokenizer.nextElement().toString();
    }
    Arrays.stream(parsedBeneficiaryTokens).forEach(token -> System.out.println(token));
    return parsedBeneficiaryTokens;
  }

  private boolean hasMoreExpensesToAdd() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Would you like to enter an expense to the settlement? Please enter Y if you would like to.");
    String moreExpensesRequired = scanner.next();
    if (moreExpensesRequired != null && "Y".equals(moreExpensesRequired))
      return true;
    return false;
  }

}
