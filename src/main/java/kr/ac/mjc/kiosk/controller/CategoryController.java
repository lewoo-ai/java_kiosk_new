package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.Category;
import kr.ac.mjc.kiosk.domain.Product;
import kr.ac.mjc.kiosk.service.CategoryService;
import kr.ac.mjc.kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;


@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    /**
     * Show products in category
     *
     * @param categoryType
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/category/{type}")
    public Category showOne(@PathVariable("type") Integer categoryType,
                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "3") Integer size) {

        Category cat = categoryService.findByCategoryType(categoryType);
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Product> productInCategory = productService.findAllInCategory(categoryType, (Pageable) request);
        var tmp = new Category("", productInCategory);
        tmp.setCategory(cat.getCategoryName());
        return tmp;
    }


}
