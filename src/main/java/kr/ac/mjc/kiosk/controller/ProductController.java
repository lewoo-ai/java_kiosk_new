package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.dto.ProductDto;
import kr.ac.mjc.kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductDto productDto) {
        Long productId = productService.saveProduct(productDto);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }


}