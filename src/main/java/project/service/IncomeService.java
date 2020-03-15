package project.service;

import java.util.List;

import project.entity.Income;

public interface IncomeService {
    Income add(Income income);

    List<Income> getAll();
}
