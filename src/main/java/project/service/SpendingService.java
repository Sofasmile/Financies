package project.service;

import java.util.List;

import project.entity.Spending;

public interface SpendingService {
    Spending add(Spending spending);

    List<Spending> getAll();
}
