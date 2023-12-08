package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.dto.CategoryDto;
import kr.ac.mjc.kiosk.dto.ProductCategoryResponse;
import kr.ac.mjc.kiosk.dto.ProductDto;
import kr.ac.mjc.kiosk.service.CategoryService;
import kr.ac.mjc.kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<ProductCategoryResponse> list() {
        List<ProductCategoryResponse> responses = new ArrayList<>();
        List<ProductDto> products = productService.getAllProducts();
        List<CategoryDto> categories = categoryService.getAllCategories();

        for (CategoryDto category : categories) {
            List<ProductDto> productByCategory = products.stream()
                    .filter(product -> product.matchCategoryId(category.getId()))
                    .collect(Collectors.toList());

            ProductCategoryResponse response = new ProductCategoryResponse(
                    category.getCategoryName(),
                    category.getId(),
                    productByCategory
            );

            responses.add(response);
        }

        return responses;
    }
}
