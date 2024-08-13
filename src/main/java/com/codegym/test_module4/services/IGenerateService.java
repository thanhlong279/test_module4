package com.codegym.test_module4.services;

import com.codegym.test_module4.models.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGenerateService <T>{

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    void save(T t);

    Page<T> findAll(String name, Pageable pageable);

    Optional<Orders> findById(Long id);

    void delete(T t);

    void update(T t);
}
