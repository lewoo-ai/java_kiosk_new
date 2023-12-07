package kr.ac.mjc.kiosk.repository;


import kr.ac.mjc.kiosk.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartegoryRepository extends JpaRepository<Category,Integer> {


    //지정 카테고리

    List<Category> findByCategoryTypeInOrderByCategoryTypeAsc(List<Integer> categoryTypes);

    //모든 카테고리

    List<Category> findAllByOrderByCategoryType();

    //한개 카테고리

    Category findByCategoryType(Integer categoryType);



}
