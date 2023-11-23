package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.ProductInfo;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface ProductService {

    ProductInfo findOne(String productId);

    // All products for sale
    Page<ProductInfo> findUpAll(Pageable pageable);

    // All products
    Page<ProductInfo> findAll(Pageable pageable);

    // All products in selected category
    Page<ProductInfo> findAllInCategory(Integer categoryType, Pageable pageable);

    // Increase stock
    void increaseStock(String productId, int amount);

    // Decrease stock
    void decreaseStock(String productId, int amount);

    ProductInfo offSale(String productId);
    ProductInfo onSale(String productId);
    ProductInfo update(ProductInfo productInfo);
    ProductInfo save(ProductInfo productInfo);

    void delete(String productId);
}
