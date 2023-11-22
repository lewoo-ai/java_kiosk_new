package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.Product;
import kr.ac.mjc.kiosk.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class FrontController {

    private final CustomerService cs;

    @Autowired
    public FrontController(CustomerService cs) {
        this.cs = cs;
    }

    @GetMapping("/")
    public String home() {
        return "index"; // 이 부분은 웹 페이지의 이름 또는 경로로 수정해야 합니다.
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProduct(){
        List<Product> products =CustomerService.findAll();
        return ResponseEntity.ok().body(products);
    }






}
