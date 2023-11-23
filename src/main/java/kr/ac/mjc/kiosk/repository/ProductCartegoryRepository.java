package kr.ac.mjc.kiosk.repository;


import kr.ac.mjc.kiosk.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartegoryRepository extends JpaRepository<ProductCategory,Integer> {


    //지정 카테고리

    List<ProductCategory> findByCategoryTypeInOrderByCategoryTypeAsc(List<Integer> categoryTypes);

    //모든 카테고리

    List<ProductCategory> findAllByOrderByCategoryType();

    //한개 카테고리

    ProductCategory findByCategoryType(Integer categoryType);



}