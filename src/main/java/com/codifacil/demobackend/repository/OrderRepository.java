package com.codifacil.demobackend.repository;

import com.codifacil.demobackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
