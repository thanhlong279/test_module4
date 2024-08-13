package com.codegym.test_module4.services;

import com.codegym.test_module4.dto.OrderProductDTO;
import com.codegym.test_module4.models.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface IOrdersService extends IGenerateService<Orders> {
    Page<OrderProductDTO> findAllByNameOrder(Pageable pageable);
}
