package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.dto.CategoryDto;
import kr.ac.mjc.kiosk.dto.ProductDto;
import kr.ac.mjc.kiosk.service.CategoryService;
import kr.ac.mjc.kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // 새로운 엔드포인트: 특정 카테고리 코드에 해당하는 상품 목록을 반환
    @GetMapping("/categories/{categoryCode}/products")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryCode(@PathVariable String categoryCode) {
        // CategoryService를 통해 카테고리 코드에 해당하는 상품 목록 조회
        List<ProductDto> products = categoryService.getProductsByCategoryCode(categoryCode);
        // 조회된 상품 목록을 응답
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // You can add more methods for other views or functionalities as needed.
}
