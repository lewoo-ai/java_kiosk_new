package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.dto.CategoryDto;
import kr.ac.mjc.kiosk.dto.ProductDto;
import kr.ac.mjc.kiosk.service.CategoryService;
import kr.ac.mjc.kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kiosk")
public class KioskController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public KioskController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    // Product 엔드포인트들
    @GetMapping("/products/getAll")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/products/addProduct")
    public ResponseEntity<Long> addProduct(@RequestBody ProductDto productDto) {
        Long productId = productService.save(productDto);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    // Category 엔드포인트들
    @GetMapping("/categories/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/categories/getByCode/{categoryCode}")
    public ResponseEntity<CategoryDto> getCategoryByCode(@PathVariable String categoryCode) {
        CategoryDto category = categoryService.getCategoryByCode(categoryCode);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/categories/addCategory")
    public ResponseEntity<Long> addCategory(@RequestBody CategoryDto categoryDto) {
        Long categoryId = categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }

    // 다른 엔드포인트 또는 기능이 필요하면 추가할 수 있습니다.
}