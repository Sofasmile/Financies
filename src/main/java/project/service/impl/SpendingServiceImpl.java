package project.service.impl;

import java.util.List;

import project.dao.SpendingDao;
import project.dao.impl.SpendingDaoImpl;
import project.entity.Spending;
import project.service.SpendingService;

public class SpendingServiceImpl implements SpendingService {

    private SpendingDao spendingDao = new SpendingDaoImpl();

    @Override
    public Spending add(Spending spending) {
        return spendingDao.add(spending);
    }

    @Override
    public List<Spending> getAll() {
        return spendingDao.getAll();
    }
}
