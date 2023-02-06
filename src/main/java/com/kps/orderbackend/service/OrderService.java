package com.kps.orderbackend.service;

import com.kps.orderbackend.exception.ApiRequestException;
import com.kps.orderbackend.model.Order;
import com.kps.orderbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findById(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public void deleteById(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
