package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.ProductInfo;
import kr.ac.mjc.kiosk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



public class ProductController {

    private final CartService cs;

    @Autowired
    public ProductController(CartService cs) {
        this.cs = cs;
    }

    @GetMapping("/")
    public String home() {
        return "index";


    @GetMapping("/products")
    public ResponseEntity<List<ProductInfo>> findProduct(){
        List<ProductInfo> productInfos = CartService.findAll();
        return ResponseEntity.ok().body(productInfos);
    }






}
