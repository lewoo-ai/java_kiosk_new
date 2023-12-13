package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.OrderDetails;
import kr.ac.mjc.kiosk.service.OrderDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
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
    public String showOrderDetailsPage(@PathVariable Long orderId, Model model) {
        List<OrderDetails> orderDetails = orderDetailsService.getOrderDetailsByOrderId(orderId);
        model.addAttribute("orderDetails", orderDetails);
        return "order-details";
    }
}

