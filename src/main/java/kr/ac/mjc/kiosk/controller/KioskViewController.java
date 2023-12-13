package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.OrderDetails;
import kr.ac.mjc.kiosk.dto.CategoryDto;
import kr.ac.mjc.kiosk.dto.ProductDto;
import kr.ac.mjc.kiosk.service.CategoryService;
import kr.ac.mjc.kiosk.service.OrderDetailsService;
import kr.ac.mjc.kiosk.service.OrderService;
import kr.ac.mjc.kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kiosk")
public class KioskViewController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final OrderService orderService;
    private final OrderDetailsService orderDetailsService;

    @Autowired
    public KioskViewController(ProductService productService, CategoryService categoryService, OrderService orderService, OrderDetailsService orderDetailsService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.orderService = orderService;
        this.orderDetailsService = orderDetailsService;
    }


    @GetMapping("/KioskView")
    public String showALLKioskView() {
        return "KioskView"; // "KioskView.html" 반환
    }

    @GetMapping("/productList")
    public String showAllproductList() {
        return "productList"; // "KioskView.html" 반환
    }

    @GetMapping("/categories")
    public String showAllCategories(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/categories/{categoryCode}/products")
    public String showProductsByCategoryCode(@PathVariable String categoryCode, Model model) {
        List<ProductDto> products = categoryService.getProductsByCategoryCode(categoryCode);
        model.addAttribute("products", products);
        return "category-products";
    }

    @GetMapping("/orders/{orderId}")
    public String showOrderDetailsByOrderId(@PathVariable Long orderId, Model model) {
        List<OrderDetails> orderDetails = orderDetailsService.getOrderDetailsByOrderId(orderId);
        model.addAttribute("orderDetails", orderDetails);
        return "order-details";
    }
}