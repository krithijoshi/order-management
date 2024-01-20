package com.ms.ordermanagement.controller;

import com.ms.ordermanagement.consumer.BookConsumer;
import com.ms.ordermanagement.model.Book;
import com.ms.ordermanagement.model.Order;
import com.ms.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookConsumer consumer;

    @GetMapping
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).get();
    }

    @PostMapping
    public Book saveOrder(@RequestBody Order order){
        order.setOrderStatus("New");
        Order savedOrder = orderRepository.save(order);
        return consumer.getBookById(savedOrder.getBookId());
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id);
    }

}
