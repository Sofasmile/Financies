package project.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import project.dao.IncomeDao;
import project.dao.PriceDao;
import project.dao.SpendingDao;
import project.dao.impl.IncomeDaoImpl;
import project.dao.impl.PriceDaoImpl;
import project.dao.impl.SpendingDaoImpl;
import project.entity.Income;
import project.entity.Price;
import project.entity.Spending;
import project.service.PriceService;

public class PriceServiceImpl implements PriceService {

    private PriceDao priceDao = new PriceDaoImpl();

    private SpendingDao spendingDao = new SpendingDaoImpl();

    private IncomeDao incomeDao = new IncomeDaoImpl();

    @Override
    public Price add(Price price) {
        return priceDao.add(price);
    }

    @Override
    public List<Price> getAll() {
        return priceDao.getAll();
    }

    @Override
    public Double countNvp(Integer discountRate) {
        List<Income> incomeAll = incomeDao.getAll();
        List<Spending> spendingAll = spendingDao.getAll();

        Set<Integer> years = getCountOfYears(incomeAll);

        double nvp = 0;
        for (int i = 0; i < years.size(); i++) {
            Optional<Double> incomeMoneyPerYear = incomeAll.stream()
                    .filter(x -> years.contains(x.getLocalDate().getYear()))
                    .map(Income::getMoney).reduce(Double::sum);
            Optional<Double> spentMoneyPerYear = spendingAll.stream()
                    .filter(x -> years.contains(x.getLocalDate().getYear()))
                    .map(Spending::getMoney).reduce(Double::sum);

            double cashInflow = 0;
            if (incomeMoneyPerYear.isPresent() && spentMoneyPerYear.isPresent()) {
                cashInflow = incomeMoneyPerYear.get() - spentMoneyPerYear.get();
            }
            double coefficient = 1 + (double) discountRate / 100;

            nvp += cashInflow / Math.pow(coefficient, i);
        }
        priceDao.add(new Price(discountRate, nvp));
        return nvp;
    }

    private Set<Integer> getCountOfYears(List<Income> incomeAll) {
        Set<Integer> years = new HashSet<>();
        for (Income income : incomeAll) {
            years.add(income.getLocalDate().getYear());
        }
        return years;
    }
}
