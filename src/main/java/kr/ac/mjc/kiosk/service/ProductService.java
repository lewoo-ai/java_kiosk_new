package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Product;
import kr.ac.mjc.kiosk.dto.ProductDto;
import kr.ac.mjc.kiosk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    public Product createProduct(ProductDto productDto) {
        Product product = productDto.toEntity();
        return productRepository.save(product);
    }

    public Long save(final ProductDto productDto) {
        Product product = productDto.toEntity();
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }


}
