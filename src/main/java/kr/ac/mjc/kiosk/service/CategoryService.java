package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findByCategoryType(Integer categoryType);

    List<Category> findByCategoryTypeIn(List<Integer> categoryTypeList);

    Category save(Category category);
}
