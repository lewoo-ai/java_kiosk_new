package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Product;
import kr.ac.mjc.kiosk.dto.ProductDto;
import kr.ac.mjc.kiosk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional<ProductDto> getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        return productOptional.map(ProductDto::new);
    }

    public Integer getProductPriceByCode(String productCode) {
        Optional<Product> productOptional = productRepository.findByProductCode(productCode);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return product.getProductPrice();
        } else {
            // 상품 코드에 해당하는 상품이 없을 경우에 대한 처리 (예: 예외 발생 또는 기본값 반환)
            throw new RuntimeException("해당 상품 코드에 해당하는 상품이 없습니다.");
        }
    }


}
