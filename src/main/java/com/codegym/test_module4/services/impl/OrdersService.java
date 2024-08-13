package com.codegym.test_module4.services.impl;

import com.codegym.test_module4.dto.OrderProductDTO;
import com.codegym.test_module4.models.Orders;
import com.codegym.test_module4.repositories.IOrdersRepository;
import com.codegym.test_module4.services.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService implements IOrdersService {

    @Autowired
    IOrdersRepository ordersRepository;

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    @Override
    public void save(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public Page<Orders> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Orders> findById(Long id){
        return ordersRepository.findById(id);
    }

    @Override
    public void delete(Orders orders) {

    }

    @Override
    public void update(Orders orders) {

    }

    @Override
    public Page<OrderProductDTO> findAllByNameOrder(Pageable pageable) {
        return ordersRepository.findAllByNameContaining(pageable);
    }
}
