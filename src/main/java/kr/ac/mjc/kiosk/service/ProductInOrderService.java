package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.OrderDetails;
import kr.ac.mjc.kiosk.domain.Orders;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface ProductInOrderService {
    Page<OrderDetails> findAll(Pageable pageable);

    Page<OrderDetails> findByStatus(Integer status, Pageable pageable);

    Page<OrderDetails> findByBuyerEmail(String email, Pageable pageable);

    Page<OrderDetails> findByBuyerPhone(String phone, Pageable pageable);

    OrderDetails findOne(Long orderId);

    OrderDetails finish(Long orderId);

    OrderDetails cancel(Long orderId);

    Orders findOne(String itemId, User user);

    void update(String itemId, Integer quantity, User user);
}
