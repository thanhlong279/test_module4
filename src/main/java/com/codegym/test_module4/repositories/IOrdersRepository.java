package com.codegym.test_module4.repositories;

import com.codegym.test_module4.dto.OrderProductDTO;
import com.codegym.test_module4.models.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Long> {
//    @Query(nativeQuery = true, value = "SELECT\n" +
//            "    o.order_id AS \"orderID\",\n" +
//            "    p.name AS \"productName\",\n" +
//            "    p.price AS \"price\",\n" +
//            "    c.name AS \"category\",\n" +
//            "    o.order_date AS \"orderDate\",\n" +
//            "    o.quantity AS \"quantity\",\n" +
//            "    (p.price * o.quantity) AS \"totalAmount\"\n" +
//            "FROM\n" +
//            "    orders o\n" +
//            "        JOIN\n" +
//            "    product p ON o.product_id = p.product_id\n" +
//            "        JOIN\n" +
//            "    category c ON p.category_id = c.category_id\n"
//    )
//    Page<OrderProductDTO> findAllByNameContaining(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT\n" +
            "    o.order_id AS \"orderID\",\n" +
            "    p.name AS \"productName\",\n" +
            "    p.price AS \"price\",\n" +
            "    c.name AS \"category\",\n" +
            "    o.order_date AS \"orderDate\",\n" +
            "    o.quantity AS \"quantity\",\n" +
            "    (p.price * o.quantity) AS \"totalAmount\"\n" +
            "FROM\n" +
            "    orders o\n" +
            "        JOIN\n" +
            "    product p ON o.product_id = p.product_id\n" +
            "        JOIN\n" +
            "    category c ON p.category_id = c.category_id\n")
    Page<OrderProductDTO> findAllByNameContaining(Pageable pageable);
//    List<OrderProductDTO> findOrderProductDetails();

}
