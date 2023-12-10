package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findByOrder_Id(Long orderId);

}