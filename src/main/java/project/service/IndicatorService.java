package project.service;

import java.util.List;

import project.entity.Indicator;

public interface IndicatorService {
    Indicator add(Indicator book);

    List<Indicator> listIndicators();
}
