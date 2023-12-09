package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Category;
import kr.ac.mjc.kiosk.dto.CategoryDto;
import kr.ac.mjc.kiosk.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}