package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.ProductCategory;

import java.util.List;

public interface CategoryService {
    List<ProductCategory> findAll();

    ProductCategory findByCategoryType(Integer categoryType);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
