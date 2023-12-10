package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.OrderDetails;
import kr.ac.mjc.kiosk.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-details")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("/{orderId}")
    public List<OrderDetails> getOrderDetailsByOrderId(@PathVariable Long orderId) {
        return orderDetailsService.getOrderDetailsByOrderId(orderId);
    }
}