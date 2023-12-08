package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.Bundle;
import kr.ac.mjc.kiosk.domain.Orders;
import kr.ac.mjc.kiosk.domain.Product;
import kr.ac.mjc.kiosk.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        try {
            managerService.productInsert(product);
            return ResponseEntity.ok("Product added successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/product")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        try {
            managerService.productUpdate(product);
            return ResponseEntity.ok("Product updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/product/{productCode}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productCode) {
        try {
            managerService.productDelete(productCode);
            return ResponseEntity.ok("Product deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getOrders() {
        try {
            List<Orders> ordersList = managerService.ordersSelect();
            return ResponseEntity.ok(ordersList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
