package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.dto.CategoryDto;
import kr.ac.mjc.kiosk.service.CategoryService;
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



}