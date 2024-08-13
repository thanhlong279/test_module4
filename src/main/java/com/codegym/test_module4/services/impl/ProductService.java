package com.codegym.test_module4.services.impl;

import com.codegym.test_module4.models.Orders;
import com.codegym.test_module4.models.Product;
import com.codegym.test_module4.repositories.IProductRepository;
import com.codegym.test_module4.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Page<Product> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return null;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void update(Product product) {

    }
}
