package com.codifacil.demobackend.service;

import com.codifacil.demobackend.model.Order;
import com.codifacil.demobackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
