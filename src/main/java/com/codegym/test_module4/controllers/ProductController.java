package com.codegym.test_module4.controllers;

import com.codegym.test_module4.dto.OrderDTO;
import com.codegym.test_module4.models.Orders;
import com.codegym.test_module4.services.ICategoryService;
import com.codegym.test_module4.services.IOrdersService;
import com.codegym.test_module4.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/order")
public class ProductController {

    @Autowired
    IOrdersService ordersService;

    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public String showListOrder(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Orders> orders = ordersService.findAll(pageable);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Orders order : orders) {
            String formattedDate = order.getOrderDate().format(formatter);
            order.setFormattedDate(formattedDate);
        }
        model.addAttribute("orders", orders);
        return "orders/list";
    }

//    @GetMapping("")
//    public String listOrdersDate(Model model,
//                                 @RequestParam(value = "startDate", defaultValue = "2024-20-08") String startDate,
//                                 @RequestParam(value = "endDate", defaultValue = "2024-10-08") String endDate,
//                                 @RequestParam(value = "page", defaultValue = "0") int page,
//                                 @RequestParam(defaultValue = "5") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Orders> orders = ordersService.findAll(pageable, startDate);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        for (Orders order : orders) {
//            String formattedDate = order.getOrderDate().format(formatter);
//            order.setFormattedDate(formattedDate);
//        }
//        model.addAttribute("orders", orders);
//        return "orders/list";
//    }

    @GetMapping("/edit/{id}")
    public String viewUpdate(@PathVariable Long id, Model model) {
        Optional<Orders> order = ordersService.findById(id);
        if (order.isPresent()) {
            model.addAttribute("order", order.get());
            return "orders/update";
        } else {
            return "redirect:/order";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable Long id, Orders order, RedirectAttributes redirectAttributes) {
        try {
            Optional<Orders> existingOrder = ordersService.findById(id);

            if (existingOrder.isPresent()) {
                Orders orderToUpdate = existingOrder.get();

                orderToUpdate.setQuantity(order.getQuantity());


                ordersService.save(orderToUpdate);

                redirectAttributes.addFlashAttribute("successMessage", "Cập nhật đơn hàng thành công!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy đơn hàng để cập nhật.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi cập nhật đơn hàng.");
        }

        return "redirect:/order";

    }
}
