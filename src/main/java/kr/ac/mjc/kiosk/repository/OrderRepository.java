package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.OrderDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

    OrderDetails findByOrderId(Long orderId);

    Page<OrderDetails> findAllByOrderStatusOrderByCreateTimeDesc(Integer orderStatus, Pageable pageable);

    Page<OrderDetails> findAllByBuyerEmailOrderByOrderStatusAscCreateTimeDesc(String buyerEmail, Pageable pageable);

    Page<OrderDetails> findAllByOrderByOrderStatusAscCreateTimeDesc(Pageable pageable);

    Page<OrderDetails> findAllByBuyerPhoneOrderByOrderStatusAscCreateTimeDesc(String buyerPhone, Pageable pageable);

}
