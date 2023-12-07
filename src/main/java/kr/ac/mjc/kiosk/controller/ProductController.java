package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.ProductInfo;
import kr.ac.mjc.kiosk.service.CartService;
import kr.ac.mjc.kiosk.service.CategoryService;
import kr.ac.mjc.kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;



public class ProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;




    @GetMapping("/product")
    public Page<ProductInfo> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "3") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return productService.findAll((Pageable) request);
    }






}
