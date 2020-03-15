package project.service.impl;

import java.util.List;

import project.dao.IncomeDao;
import project.dao.impl.IncomeDaoImpl;
import project.entity.Income;
import project.service.IncomeService;

public class IncomeServiceImpl implements IncomeService {
    private IncomeDao incomeDao = new IncomeDaoImpl();

    @Override
    public Income add(Income income) {
        return incomeDao.add(income);
    }

    @Override
    public List<Income> getAll() {
        return incomeDao.getAll();
    }
}
