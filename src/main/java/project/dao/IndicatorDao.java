package project.dao;

import java.util.List;

import project.entity.Indicator;


public interface IndicatorDao {
    Indicator add(Indicator book);

    List<Indicator> listIndicators();

}
