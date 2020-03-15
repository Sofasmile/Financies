package project.dao;

import java.util.List;

import project.entity.Spending;

public interface SpendingDao {
    Spending add(Spending spending);

    List<Spending> getAll();
}
