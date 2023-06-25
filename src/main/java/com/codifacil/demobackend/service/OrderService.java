package com.codifacil.demobackend.service;

import com.codifacil.demobackend.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAll();

    Optional<Order> getById(Integer id);

    Order save(Order order);

    void delete(Integer id);

}
