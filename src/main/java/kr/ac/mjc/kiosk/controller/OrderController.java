package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Long createOrder() {
        return orderService.createOrder();
    }

    @PostMapping("/{orderId}/add-product")
    public void addProductToOrder(@PathVariable Long orderId, @RequestParam String productCode) {
        orderService.addProductToOrder(orderId, productCode);
    }
}