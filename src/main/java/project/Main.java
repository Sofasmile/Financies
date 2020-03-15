package project;

import project.service.IncomeService;
import project.service.impl.IncomeServiceImpl;

public class Main {
  public static void main(String[] args) {
    IncomeService incomeService = new IncomeServiceImpl();
    incomeService.getAll();
  }
}
