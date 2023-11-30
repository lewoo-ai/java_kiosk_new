package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.ProductCategory;
import kr.ac.mjc.kiosk.domain.ProductInfo;
import kr.ac.mjc.kiosk.repository.CategoryPage;
import kr.ac.mjc.kiosk.service.CategoryService;
import kr.ac.mjc.kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import kr.ac.mjc.kiosk.validation.response.CategoryPage;

import java.awt.print.Pageable;


@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/category/{type}")
    public CategoryPage showOne(@PathVariable("type") Integer categoryType,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "3") Integer size) {

        ProductCategory cat = categoryService.findByCategoryType(categoryType);
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductInfo> productInCategory = productService.findAllInCategory(categoryType, (Pageable) request);
        var tmp = new CategoryPage("", productInCategory);
        tmp.setCategory(cat.getCategoryName());
        return tmp;
    }



}
