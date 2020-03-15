package project.dao;

import java.util.List;

import project.entity.Income;


public interface IncomeDao {
    Income add(Income income);

    List<Income> getAll();
}
