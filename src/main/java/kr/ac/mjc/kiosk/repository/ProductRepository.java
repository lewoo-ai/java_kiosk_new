package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductInfo,Integer> {



}
