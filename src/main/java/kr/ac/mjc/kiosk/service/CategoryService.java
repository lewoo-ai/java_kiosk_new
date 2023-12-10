package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Category;
import kr.ac.mjc.kiosk.domain.Product;
import kr.ac.mjc.kiosk.dto.CategoryDto;
import kr.ac.mjc.kiosk.dto.ProductDto;
import kr.ac.mjc.kiosk.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> findCategoryByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryDto::new)
                .collect(Collectors.toList());
    }

    public CategoryDto getCategoryByCode(String categoryCode) {
        return categoryRepository.findByCategoryCode(categoryCode)
                .map(CategoryDto::new)
                .orElse(null);
    }

    public Long saveCategory(CategoryDto categoryDto) {
        Category category = categoryDto.toEntity();
        Category savedCategory = categoryRepository.save(category);
        return savedCategory.getId();
    }

    public Optional<CategoryDto> getCategoryById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        return categoryOptional.map(CategoryDto::new);
    }


    // 새로운 메서드: 카테고리 코드에 해당하는 상품 목록 조회
    public List<ProductDto> getProductsByCategoryCode(String categoryCode) {
        // CategoryRepository에서 해당 카테고리 코드에 해당하는 상품 목록을 조회하는 메서드 호출
        List<Product> products = categoryRepository.findByCategoryCode(categoryCode)
                .map(Category::getProductList)
                .orElse(Collections.emptyList());
        // Product 엔티티를 ProductDto로 변환
        List<ProductDto> productDtos = products.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
        return productDtos;
    }


}