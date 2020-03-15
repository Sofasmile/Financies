package project.dao;

import java.util.List;

import project.entity.Price;

public interface PriceDao {
    Price add(Price price);

    List<Price> getAll();
}
