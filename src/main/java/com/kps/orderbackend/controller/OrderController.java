package com.kps.orderbackend.controller;

import com.kps.orderbackend.exception.ApiRequestException;
import com.kps.orderbackend.model.Item;
import com.kps.orderbackend.model.Order;
import com.kps.orderbackend.response.ResponseHandler;
import com.kps.orderbackend.service.ItemService;
import com.kps.orderbackend.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Order order) {
        Item existItem = itemService.findById(order.getItem().getId());
        if(existItem == null){
            throw new NoSuchElementException("Invalid item");
        }else{
            order.setItem(existItem);
            Order savedOrder = orderService.save(order);
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        LOGGER.info("-------- Retrieving all orders ----------");
        int a = 30;
        int b = a;
        b = 70;
        System.out.println(b);
        System.out.println(a);
        return ResponseHandler.responseBuilder("", HttpStatus.OK, orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        LOGGER.info("------- Find By Id ----------");
        if(id < 1){
            throw new ApiRequestException("ID should be greater than 0", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.responseBuilder("", HttpStatus.OK, orderService.findById(id));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> delete(@PathVariable Long orderId) {
        orderService.deleteById(orderId);
        return ResponseEntity.noContent().build();
    }
}
