package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {
}
