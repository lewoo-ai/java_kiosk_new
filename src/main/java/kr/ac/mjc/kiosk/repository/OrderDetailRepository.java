package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
