package com.codegym.test_module4.services.impl;

import com.codegym.test_module4.models.Category;
import com.codegym.test_module4.models.Orders;
import com.codegym.test_module4.repositories.ICategoryRepository;
import com.codegym.test_module4.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public Page<Category> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return null;
    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void update(Category category) {

    }
}
