package kr.ac.mjc.kiosk.controller;

import ch.qos.logback.core.model.Model;
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
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/getByCode/{categoryCode}")
    public ResponseEntity<CategoryDto> getCategoryByCode(@PathVariable String categoryCode) {
        CategoryDto category = categoryService.getCategoryByCode(categoryCode);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Long> addCategory(@RequestBody CategoryDto categoryDto) {
        Long categoryId = categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }



    // 새로운 엔드포인트: 특정 카테고리 코드에 해당하는 상품 목록을 반환
    @GetMapping("/{categoryCode}/products")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryCode(@PathVariable String categoryCode) {
        // CategoryService를 통해 카테고리 코드에 해당하는 상품 목록 조회
        List<ProductDto> products = categoryService.getProductsByCategoryCode(categoryCode);
        // 조회된 상품 목록을 응답
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}