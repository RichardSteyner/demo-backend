package com.codifacil.demobackend.controller;

import com.codifacil.demobackend.model.Order;
import com.codifacil.demobackend.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin({"*"})
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Integer id) {
        Order order = service.getById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> save(@Valid @RequestBody Order order) {
        try {
            return ResponseEntity.ok(service.save(order));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
