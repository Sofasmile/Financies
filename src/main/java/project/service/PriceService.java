package project.service;

import java.util.List;

import project.entity.Price;

public interface PriceService {
    Price add(Price price);

    List<Price> getAll();

    Double countNvp(Integer discountRate);
}
