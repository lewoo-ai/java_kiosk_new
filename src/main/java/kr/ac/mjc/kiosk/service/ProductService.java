package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Product;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface ProductService {

    Product findOne(String productId);

    // All products for sale
    Page<Product> findUpAll(Pageable pageable);

    // All products
    Page<Product> findAll(Pageable pageable);

    // All products in selected category
    Page<Product> findAllInCategory(Integer categoryType, Pageable pageable);

    // Increase stock
    void increaseStock(String productId, int amount);

    // Decrease stock
    void decreaseStock(String productId, int amount);

    Product offSale(String productId);
    Product onSale(String productId);
    Product update(Product product);
    Product save(Product product);

    void delete(String productId);
}
