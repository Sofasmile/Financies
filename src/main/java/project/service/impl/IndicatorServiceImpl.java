package project.service.impl;

import java.util.List;

import project.dao.IndicatorDao;
import project.dao.impl.IndicatorDaoImpl;
import project.entity.Indicator;
import project.service.IndicatorService;

public class IndicatorServiceImpl implements IndicatorService {
    private final IndicatorDao indicatorDao = new IndicatorDaoImpl();

    @Override
    public Indicator add(Indicator indicator) {
        return indicatorDao.add(indicator);
    }

    @Override
    public List<Indicator> listIndicators() {
        return indicatorDao.listIndicators();
    }


}
