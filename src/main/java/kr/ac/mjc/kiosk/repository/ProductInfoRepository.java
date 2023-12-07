package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<Product,Integer> {

    Product findByproductId(String id);

    Page<Product> findAllByProductStatusOrderByProductIdAsc(Integer productStatus, Pageable pageable);

    Page<Product> findAllByCategoryTypeOrderByProductIdAsc(Integer categoryType, Pageable pageable);

    Page<Product> findAllByOrderByProductId(Pageable pageable);

}
