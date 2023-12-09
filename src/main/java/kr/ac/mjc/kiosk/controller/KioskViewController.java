package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.dto.CategoryDto;
import kr.ac.mjc.kiosk.dto.ProductDto;
import kr.ac.mjc.kiosk.service.CategoryService;
import kr.ac.mjc.kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class KioskViewController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public KioskViewController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/kiosk/products")
    public String showProducts(Model model) {
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList"; // Assuming you have a Thymeleaf template named productList.html
    }

    @GetMapping("/kiosk/products/{id}")
    public String showProductDetails(@PathVariable Long id, Model model) {
        Optional<ProductDto> productOptional = productService.getProductById(id);

        if (productOptional.isPresent()) {
            ProductDto product = productOptional.get();
            model.addAttribute("product", product);
            return "productDetails";
        } else {
            // 처리할 내용 (예: 해당 ID에 해당하는 제품이 없을 때의 에러 페이지로 이동)
            return "errorPage";
        }
    }

    @GetMapping("/kiosk/categories")
    public String showCategories(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categoryList"; // Assuming you have a Thymeleaf template named categoryList.html
    }

    @GetMapping("/kiosk/categories/{id}")
    public String showCategoryDetails(@PathVariable Long id, Model model) {
        Optional<CategoryDto> categoryOptional = categoryService.getCategoryById(id);

        if (categoryOptional.isPresent()) {
            CategoryDto category = categoryOptional.get();
            model.addAttribute("category", category);
            return "categoryDetails";
        } else {
            // 처리할 내용 (예: 해당 ID에 해당하는 카테고리가 없을 때의 에러 페이지로 이동)
            return "errorPage";
        }
    }

    // You can add more methods for other views or functionalities as needed.
}