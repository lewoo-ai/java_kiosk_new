package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll(); // 모든 상품을 조회

    Optional<Product> findByProductCode(String productCode);
}

