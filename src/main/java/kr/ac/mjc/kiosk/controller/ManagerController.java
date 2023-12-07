package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.Category; // Category 클래스로 변경
import kr.ac.mjc.kiosk.domain.Orders; // Orders 클래스로 변경
import kr.ac.mjc.kiosk.domain.OrdersDetails; // OrdersDetails 클래스로 변경
import kr.ac.mjc.kiosk.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/products")
    public List<Category> getProductsByCategory() {
        return customerService.selectProductByCategory();
    }

    @PostMapping("/orders")
    public ResponseEntity<?> insertOrders(@RequestBody List<OrdersDetails> ordersDetailsList) {
        Orders orders = new Orders();
        orders.setOrdersDetailsList(ordersDetailsList);

        try {
            customerService.insertOrders(orders);
            return ResponseEntity.ok("Orders inserted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to insert orders.");
        }
    }
}
