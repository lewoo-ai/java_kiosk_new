package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {



}
