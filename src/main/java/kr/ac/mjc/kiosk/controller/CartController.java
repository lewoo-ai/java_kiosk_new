package kr.ac.mjc.kiosk.controller;

import kr.ac.mjc.kiosk.domain.Cart;
import kr.ac.mjc.kiosk.domain.ProductInOrder;

import kr.ac.mjc.kiosk.dto.ItemForm;

import kr.ac.mjc.kiosk.repository.ProductInOrderRepository;
import kr.ac.mjc.kiosk.service.CartService;
import kr.ac.mjc.kiosk.service.ProductInOrderService;
import kr.ac.mjc.kiosk.service.ProductService;
import kr.ac.mjc.kiosk.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;


@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductInOrderService productInOrderService;
    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @PostMapping("")
    public ResponseEntity<Cart> mergeCart(@RequestBody Collection<ProductInOrder> productInOrders) {

        try {
            cartService.mergeLocalCart(productInOrders, null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Merge Cart Failed");
        }
        return ResponseEntity.ok(cartService.getCart(null));
    }

    @GetMapping("")
    public Cart getCart() {

        return cartService.getCart(null);
    }

    @PostMapping("/add")
    public boolean addToCart(@RequestBody ItemForm form) {
        var productInfo = productService.findOne(form.getProductId());
        try {
            mergeCart(Collections.singleton(new ProductInOrder(productInfo, form.getQuantity())));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @PutMapping("/itemId")
    public ProductInOrder modifyItem(@PathVariable("itemId") String itemId, @RequestBody Integer quantity) {
        productInOrderService.update(itemId, quantity, null);
        return productInOrderService.findOne(itemId, null);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable("itemId") String itemId) {
        cartService.delete(itemId, null);
        // flush memory into database
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout() {
        cartService.checkout(null);
        return ResponseEntity.ok("Checkout successful");
    }
}
