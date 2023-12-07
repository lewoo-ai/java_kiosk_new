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

    @PostMapping("/bundle")
    public ResponseEntity<String> addBundle(@RequestBody Bundle bundle) {
        try {
            managerService.bundleInsert(bundle);
            return ResponseEntity.ok("Bundle added successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/bundle")
    public ResponseEntity<String> updateBundle(@RequestBody Bundle bundle) {
        try {
            managerService.bundleUpdate(bundle);
            return ResponseEntity.ok("Bundle updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/bundle/{bundleCode}")
    public ResponseEntity<String> deleteBundle(@PathVariable String bundleCode) {
        try {
            managerService.bundleDelete(bundleCode);
            return ResponseEntity.ok("Bundle deleted successfully.");
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
